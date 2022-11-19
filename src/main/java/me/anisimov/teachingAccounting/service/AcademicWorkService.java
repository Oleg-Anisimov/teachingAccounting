package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.repository.AcademicWorkRepository;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public AcademicWorkDto createAcademicWork(AcademicWorkDto academicWorkDto) {
        AcademicWork academicWork = new AcademicWork();
        academicWork.setId(academicWorkDto.getId());
        academicWork.setGroup(groupService.getById(academicWorkDto.getGroupId()));
        academicWork.setAcademicYear(academicWorkDto.getAcademicYear());
        academicWork.setFirstSemester(academicWorkDto.getFirstSemester());
        academicWork.setSecondSemester(academicWorkDto.getSecondSemester());
        academicWork.setAcademicDiscipline(academicDisciplineService.getById(academicWorkDto.getAcademicDisciplineId()));
        academicWork.setSpecialization(specializationService.getById(academicWorkDto.getSpecializationId()));
        academicWork.setAbsoluteResults(academicWorkDto.getAbsoluteResults());
        academicWork.setQualityResults(academicWorkDto.getQualityResults());
        academicWork.setIncompleteReason(academicWorkDto.getIncompleteReason());
        academicWorkRepository.save(academicWork);
        return mapper.map(academicWork, AcademicWorkDto.class);
    }

    public void deleteAcademicWork(Long id) {
        academicWorkRepository.deleteById(id);
    }

    public void updateAcademicWork(AcademicWork academicWork) {
        academicWorkRepository.save(academicWork);
    }

    public AcademicWork getById(Long id) {
        return academicWorkRepository.getReferenceById(id);
    }

    public List<AcademicWork> getAll(){
        return academicWorkRepository.findAll();
    }

}
