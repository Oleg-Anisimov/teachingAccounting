package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicMethodsActivityType;
import me.anisimov.teachingAccounting.dto.AcademicMethodsActivityTypeDto;
import me.anisimov.teachingAccounting.repository.AcademicMethodsActivityTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicMethodsActivityTypeService {

    @Autowired
    private AcademicMethodsActivityTypeRepository academicMethodsActivityTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public AcademicMethodsActivityTypeDto createAcademicMethodsActivityType(AcademicMethodsActivityTypeDto academicMethodsActivityTypeDto){
        AcademicMethodsActivityType academicMethodsActivityType = new AcademicMethodsActivityType();
        academicMethodsActivityType.setId(academicMethodsActivityTypeDto.getId());
        academicMethodsActivityType.setName(academicMethodsActivityTypeDto.getName());
        academicMethodsActivityTypeRepository.save(academicMethodsActivityType);
        return mapper.map(academicMethodsActivityType, AcademicMethodsActivityTypeDto.class);
    }

    public void deleteAcademicMethodsActivityType(Long id) {
        academicMethodsActivityTypeRepository.deleteById(id);
    }

    public void updateAcademicMethodsActivityType(AcademicMethodsActivityType academicMethodsActivityType) {
        academicMethodsActivityTypeRepository.save(academicMethodsActivityType);
    }

    public AcademicMethodsActivityType getById(Long id) {
        return academicMethodsActivityTypeRepository.getReferenceById(id);
    }

    public List<AcademicMethodsActivityType> getAll() {
        return academicMethodsActivityTypeRepository.findAll();
    }
}
