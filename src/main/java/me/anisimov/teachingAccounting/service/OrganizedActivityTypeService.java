package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.OrganizedActivityType;
import me.anisimov.teachingAccounting.dto.OrganizedActivityTypeDto;
import me.anisimov.teachingAccounting.repository.OrganizedActivityTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrganizedActivityTypeService {

    @Autowired
    private OrganizedActivityTypeRepository organizedActivityTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public OrganizedActivityTypeDto createOrganizedActivityType(OrganizedActivityTypeDto organizedActivityTypeDto){
        OrganizedActivityType organizedActivityType = new OrganizedActivityType();
        organizedActivityType.setId(organizedActivityTypeDto.getId());
        organizedActivityType.setName(organizedActivityTypeDto.getName());
        organizedActivityTypeRepository.save(organizedActivityType);
        return mapper.map(organizedActivityType, OrganizedActivityTypeDto.class);
    }

    public void deleteOrganizedActivityType(Long id) {
        organizedActivityTypeRepository.deleteById(id);
    }

    public void updateOrganizedActivityType(OrganizedActivityType organizedActivityType) {
        organizedActivityTypeRepository.save(organizedActivityType);
    }

    public OrganizedActivityType getById(Long id) {
        return organizedActivityTypeRepository.getReferenceById(id);
    }

    public List<OrganizedActivityType> getAll() {
        return organizedActivityTypeRepository.findAll();
    }
}
