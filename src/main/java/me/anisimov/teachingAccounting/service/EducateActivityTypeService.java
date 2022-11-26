package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.EducateActivityType;
import me.anisimov.teachingAccounting.dto.EducateActivityTypeDto;
import me.anisimov.teachingAccounting.repository.EducateActivityTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EducateActivityTypeService {

    @Autowired
    private EducateActivityTypeRepository educateActivityTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public EducateActivityTypeDto createEducateActivityType(EducateActivityTypeDto educateActivityTypeDto){
        EducateActivityType educateActivityType = new EducateActivityType();
        educateActivityType.setId(educateActivityTypeDto.getId());
        educateActivityType.setName(educateActivityTypeDto.getName());
        educateActivityTypeRepository.save(educateActivityType);
        return mapper.map(educateActivityType, EducateActivityTypeDto.class);
    }

    public void deleteEducateActivityType(Long id) {
        educateActivityTypeRepository.deleteById(id);
    }

    public void updateEducateActivityType(EducateActivityType EducateActivityType) {
        educateActivityTypeRepository.save(EducateActivityType);
    }

    public EducateActivityType getById(Long id) {
        return educateActivityTypeRepository.getReferenceById(id);
    }

    public List<EducateActivityType> getAll() {
        return educateActivityTypeRepository.findAll();
    }
}
