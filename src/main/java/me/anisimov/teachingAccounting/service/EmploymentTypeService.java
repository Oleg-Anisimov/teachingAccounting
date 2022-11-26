package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Category;
import me.anisimov.teachingAccounting.domain.EmploymentType;
import me.anisimov.teachingAccounting.dto.EmploymentTypeDto;
import me.anisimov.teachingAccounting.repository.EmploymentTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EmploymentTypeService {

    @Autowired
    private EmploymentTypeRepository employmentTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public EmploymentTypeDto createEmploymentType(EmploymentTypeDto employmentTypeDto){
        EmploymentType employmentType = new EmploymentType();
        employmentType.setId(employmentTypeDto.getId());
        employmentType.setName(employmentTypeDto.getName());
        employmentTypeRepository.save(employmentType);
        return mapper.map(employmentType,EmploymentTypeDto.class);
    }

    public void deleteEmploymentType(Long id) {
        employmentTypeRepository.deleteById(id);
    }

    public void updateEmploymentType(EmploymentType employmentType) {
        employmentTypeRepository.save(employmentType);
    }

    public EmploymentType getById(Long id) {
        return employmentTypeRepository.getReferenceById(id);
    }

    public List<EmploymentType> getAll() {
        return employmentTypeRepository.findAll();
    }
}
