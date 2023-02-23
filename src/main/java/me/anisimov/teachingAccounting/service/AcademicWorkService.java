package me.anisimov.teachingAccounting.service;

import liquibase.pro.packaged.A;
import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.PlanAndFact;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.dto.TeacherDto;
import me.anisimov.teachingAccounting.repository.AcademicWorkRepository;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AcademicWorkService {
    @Autowired
    private AcademicWorkRepository academicWorkRepository;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private AcademicDisciplineService academicDisciplineService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private ExportToExcelService exportToExcelService;
    @Autowired
    private EntityRepository entityRepository;

    public AcademicWorkDto createAcademicWork(AcademicWorkDto academicWorkDto) {

        Long userId = academicWorkDto.getUserId();
        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        AcademicWork academicWork = new AcademicWork();
        academicWork.setUser(user);
        academicWork.setGroup(groupService.getById(academicWorkDto.getGroupId()));
        academicWork.setAcademicYear(new PlanAndFact(
                academicWorkDto.getFirstSemester().getPlan()+academicWorkDto.getSecondSemester().getPlan(),
                        academicWorkDto.getFirstSemester().getFact()+academicWorkDto.getSecondSemester().getFact())
        );
        academicWork.setFirstSemester(academicWorkDto.getFirstSemester());
        academicWork.setSecondSemester(academicWorkDto.getSecondSemester());
        academicWork.setAcademicDiscipline(academicDisciplineService.getById(academicWorkDto.getAcademicDisciplineId()));
        academicWork.setSpecialization(specializationService.getById(academicWorkDto.getSpecializationId()));
        academicWork.setAbsoluteResults(academicWorkDto.getAbsoluteResults());
        academicWork.setQualityResults(academicWorkDto.getQualityResults());
        academicWork.setIncompleteReason(academicWorkDto.getIncompleteReason());
        academicWork = academicWorkRepository.save(academicWork);
        return mapper.map(academicWork, AcademicWorkDto.class);
    }

    public void deleteAcademicWork(Long id) {
        academicWorkRepository.deleteById(id);
    }

    public void updateAcademicWork(AcademicWorkDto academicWorkDto) {
       AcademicWork academicWork = academicWorkRepository.getReferenceById(academicWorkDto.getId());
        academicWork.setGroup(groupService.getById(academicWorkDto.getGroupId()));
        academicWork.setAcademicYear(new PlanAndFact(
                academicWorkDto.getFirstSemester().getPlan()+academicWorkDto.getSecondSemester().getPlan(),
                academicWorkDto.getFirstSemester().getFact()+academicWorkDto.getSecondSemester().getFact())
        );
        academicWork.setFirstSemester(academicWorkDto.getFirstSemester());
        academicWork.setSecondSemester(academicWorkDto.getSecondSemester());
        academicWork.setAcademicDiscipline(academicDisciplineService.getById(academicWorkDto.getAcademicDisciplineId()));
        academicWork.setSpecialization(specializationService.getById(academicWorkDto.getSpecializationId()));
        academicWork.setAbsoluteResults(academicWorkDto.getAbsoluteResults());
        academicWork.setQualityResults(academicWorkDto.getQualityResults());
        academicWork.setIncompleteReason(academicWorkDto.getIncompleteReason());
        academicWorkRepository.save(academicWork);
    }

    public AcademicWork getById(Long id) {
        return academicWorkRepository.getReferenceById(id);
    }

    public List<AcademicWorkDto> getAll() {
        return academicWorkRepository.findAll().stream()
                .map(entity -> mapper.map(entity, AcademicWorkDto.class))
                .collect(Collectors.toList());
    }

    public Page<AcademicWorkDto> getCurrentAcademicWork(PageRequest pageRequest) {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        Page<AcademicWorkDto> allUsersInformation = academicWorkRepository.getAllByUser(user, pageRequest)
                .map(work -> {
                    return mapper.map(work, AcademicWorkDto.class);
                });
        return allUsersInformation;
    }

    public FileSystemResource exportToExcel() {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        List<AcademicWork> academicWorks = entityRepository.listForUser(AcademicWork.class, user);

        String[] fieldNames = {
                "id", "specialization.specialization", "academicDiscipline.disciplineNumber",
                "academicDiscipline.name", "group.groupName", "firstSemester.plan", "firstSemester.fact",
                "secondSemester.plan", "secondSemester.fact", "academicYear.plan", "academicYear.fact",
                "incompleteReason", "absoluteResults", "qualityResults"
        };
        String filename = "AcademicWork_" + LocalDate.now() + ".xlsx";
        exportToExcelService.export(filename, fieldNames, academicWorks);
        return new FileSystemResource(new File(filename));
    }

}
