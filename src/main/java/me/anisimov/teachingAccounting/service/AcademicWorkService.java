package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.repository.AcademicWorkRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AcademicWorkService {
    @Autowired
    AcademicWorkRepository academicWorkRepository;
    @Autowired
    DozerBeanMapper mapper;

    public AcademicWorkDto createAcademicWork(AcademicWorkDto academicWorkDto){
        AcademicWork academicWork = new AcademicWork();
        academicWork.setId(academicWorkDto.getId());
        academicWork.setGroupName(academicWorkDto.getGroupName());
        academicWork.setAcademicYear(academicWorkDto.getAcademicYear());
        academicWork.setFirstSemester(academicWorkDto.getFirstSemester());
        academicWork.setSecondSemester(academicWorkDto.getSecondSemester());
        academicWork.setAcademicDiscipline(academicWorkDto.getAcademicDiscipline());
        academicWork.setSpecialization(academicWorkDto.getSpecialization());
        academicWork.setAbsoluteResults(academicWorkDto.getAbsoluteResults());
        academicWork.setQualityResults(academicWorkDto.getQualityResults());
        academicWork.setIncompleteReason(academicWorkDto.getIncompleteReason());
        academicWorkRepository.save(academicWork);
        return mapper.map(academicWork,AcademicWorkDto.class);
    }
    public void deleteAcademicWork(Long id){
        academicWorkRepository.deleteById(id);
    }
    public void updateAcademicWork(AcademicWork academicWork){
        academicWorkRepository.save(academicWork);
    }

    public AcademicWork getById(Long id){
        return academicWorkRepository.getReferenceById(id);
    }

}
