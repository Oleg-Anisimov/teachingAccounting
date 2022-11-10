package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.repository.AcademicMethodsRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AcademicMethodsService {

    @Autowired
    AcademicMethodsRepository academicMethodsRepository;
    @Autowired
    DozerBeanMapper mapper;

    public AcademicMethodsDto createAcademicMethods(AcademicMethodsDto academicMethodsDto) {
        AcademicMethods academicMethods = new AcademicMethods();
        academicMethods.setId(academicMethodsDto.getId());
        academicMethods.setAcademicDiscipline(academicMethodsDto.getAcademicDiscipline());
        academicMethods.setAcademicMethodActivityForm(academicMethodsDto.getAcademicMethodActivityForm());
        academicMethods.setAcademicMethodActivityType(academicMethodsDto.getAcademicMethodActivityType());
        academicMethods.setSpecialization(academicMethodsDto.getSpecialization());
        academicMethods.setActivityType(academicMethodsDto.getActivityType());
        academicMethods.setDeadLine(academicMethodsDto.getDeadLine());
        academicMethods.setCompleteInfo(academicMethodsDto.getCompleteInfo());
        academicMethodsRepository.save(academicMethods);
        return mapper.map(academicMethods, AcademicMethodsDto.class);
    }
        public void deleteAcademicMethods(Long id){
            academicMethodsRepository.deleteById(id);
        }
        public void updateAcademicMethods(AcademicMethods academicMethods){
            academicMethodsRepository.save(academicMethods);
        }

        public AcademicMethods getById(Long id){
            return academicMethodsRepository.getReferenceById(id);
        }
    }

