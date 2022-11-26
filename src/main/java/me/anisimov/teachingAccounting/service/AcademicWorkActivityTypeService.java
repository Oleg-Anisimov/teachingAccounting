package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicWorkActivityType;
import me.anisimov.teachingAccounting.dto.AcademicWorkActivityTypeDto;
import me.anisimov.teachingAccounting.repository.AcademicWorkActivityTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicWorkActivityTypeService {

    @Autowired
    private AcademicWorkActivityTypeRepository academicWorkActivityTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public AcademicWorkActivityTypeDto createAcademicWorkActivityType(AcademicWorkActivityTypeDto academicWorkActivityTypeDto){
        AcademicWorkActivityType academicWorkActivityType = new AcademicWorkActivityType();
        academicWorkActivityType.setId(academicWorkActivityTypeDto.getId());
        academicWorkActivityType.setName(academicWorkActivityTypeDto.getName());
        academicWorkActivityTypeRepository.save(academicWorkActivityType);
        return mapper.map(academicWorkActivityType, AcademicWorkActivityTypeDto.class);
    }

    public void deleteAcademicWorkActivityType(Long id) {
        academicWorkActivityTypeRepository.deleteById(id);
    }

    public void updateAcademicWorkActivityType(AcademicWorkActivityType academicWorkActivityType) {
        academicWorkActivityTypeRepository.save(academicWorkActivityType);
    }

    public AcademicWorkActivityType getById(Long id) {
        return academicWorkActivityTypeRepository.getReferenceById(id);
    }

    public List<AcademicWorkActivityType> getAll() {
        return academicWorkActivityTypeRepository.findAll();
    }
}
