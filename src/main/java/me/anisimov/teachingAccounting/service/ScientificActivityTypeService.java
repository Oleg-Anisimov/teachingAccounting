package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.ScientificActivityType;
import me.anisimov.teachingAccounting.dto.ScientificActivityTypeDto;
import me.anisimov.teachingAccounting.repository.ScientificActivityTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ScientificActivityTypeService {

    @Autowired
    private ScientificActivityTypeRepository ScientificActivityTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public ScientificActivityTypeDto createScientificActivityType(ScientificActivityTypeDto scientificActivityTypeDto){
        ScientificActivityType scientificActivityType = new ScientificActivityType();
        scientificActivityType.setId(scientificActivityTypeDto.getId());
        scientificActivityType.setName(scientificActivityTypeDto.getName());
        ScientificActivityTypeRepository.save(scientificActivityType);
        return mapper.map(scientificActivityType,ScientificActivityTypeDto.class);
    }

    public void deleteScientificActivityType(Long id) {
        ScientificActivityTypeRepository.deleteById(id);
    }

    public void updateScientificActivityType(ScientificActivityType scientificActivityType) {
        ScientificActivityTypeRepository.save(scientificActivityType);
    }

    public ScientificActivityType getById(Long id) {
        return ScientificActivityTypeRepository.getReferenceById(id);
    }

    public List<ScientificActivityType> getAll() {
        return ScientificActivityTypeRepository.findAll();
    }
}
