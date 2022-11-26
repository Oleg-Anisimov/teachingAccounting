package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.repository.AcademicMethodsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicMethodsService {

    @Autowired
    private AcademicMethodsRepository academicMethodsRepository;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private AcademicDisciplineService academicDisciplineService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AcademicWorkActivityTypeService academicWorkActivityTypeService;
    @Autowired
    private AcademicMethodsActivityFormService academicMethodsActivityFormService;
    @Autowired
    private AcademicMethodsActivityTypeService academicMethodsActivityTypeService;

    public AcademicMethodsDto createAcademicMethods(AcademicMethodsDto academicMethodsDto) {
        AcademicMethods academicMethods = new AcademicMethods();
        academicMethods.setId(academicMethodsDto.getId());
        academicMethods.setAcademicDiscipline(academicDisciplineService.getById(academicMethodsDto.getAcademicDisciplineId()));
        academicMethods.setAcademicMethodActivityForm(academicMethodsActivityFormService.getById(academicMethodsDto.getAcademicMethodActivityFormId()));
        academicMethods.setAcademicMethodActivityType(academicMethodsActivityTypeService.getById(academicMethodsDto.getAcademicMethodActivityTypeId()));
        academicMethods.setSpecialization(specializationService.getById(academicMethodsDto.getSpecializationId()));
        academicMethods.setAcademicWorkActivityType(academicWorkActivityTypeService.getById(academicMethodsDto.getAcademicWorkActivityTypeId()));
        academicMethods.setDeadLine(academicMethodsDto.getDeadLine());
        academicMethods.setCompleteInfo(academicMethodsDto.getCompleteInfo());
        academicMethodsRepository.save(academicMethods);
        return mapper.map(academicMethods, AcademicMethodsDto.class);
    }

    public void deleteAcademicMethods(Long id) {
        academicMethodsRepository.deleteById(id);
    }

    public void updateAcademicMethods(AcademicMethods academicMethods) {
        academicMethodsRepository.save(academicMethods);
    }

    public AcademicMethods getById(Long id) {
        return academicMethodsRepository.getReferenceById(id);
    }

    public List<AcademicMethods> getAll(){
        return academicMethodsRepository.findAll();
    }
}

