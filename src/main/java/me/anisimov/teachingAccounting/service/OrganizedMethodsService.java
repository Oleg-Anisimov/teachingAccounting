package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.OrganizedMethods;
import me.anisimov.teachingAccounting.dto.OrganizedMethodsDto;
import me.anisimov.teachingAccounting.repository.OrganizedMethodsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrganizedMethodsService {

    @Autowired
    private OrganizedMethodsRepository organizedMethodsRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private OrganizedActivityTypeService organizedActivityTypeService;
    @Autowired
    private EventLevelService eventLevelService;
    @Autowired
    private EventTypeService eventTypeService;

    public OrganizedMethodsDto createOrganizedMethods(OrganizedMethodsDto organizedMethodsDto) {
        OrganizedMethods organizedMethods = new OrganizedMethods();
        organizedMethods.setId(organizedMethodsDto.getId());
        organizedMethods.setDate(organizedMethodsDto.getDate());
        organizedMethods.setResult(organizedMethodsDto.getResult());
        organizedMethods.setEventName(organizedMethodsDto.getEventName());
        organizedMethods.setEventLevel(eventLevelService.getById(organizedMethodsDto.getEventLevelId()));
        organizedMethods.setEventType(eventTypeService.getById(organizedMethodsDto.getEventTypeId()));
        organizedMethods.setStudentInformation(organizedMethodsDto.getStudentInformation());
        organizedMethods.setActivityType(organizedActivityTypeService.getById(organizedMethodsDto.getOrganizedActivityTypeId()));
        organizedMethodsRepository.save(organizedMethods);
        return mapper.map(organizedMethods, OrganizedMethodsDto.class);
    }

    public void deleteOrganizedMethods(Long id) {
        organizedMethodsRepository.deleteById(id);
    }

    public void updateOrganizedMethods(OrganizedMethods organizedMethods) {
        organizedMethodsRepository.save(organizedMethods);
    }

    public OrganizedMethods getById(Long id) {
        return organizedMethodsRepository.getReferenceById(id);
    }

    public List<OrganizedMethods> getAll() {
        return organizedMethodsRepository.findAll();
    }
}
