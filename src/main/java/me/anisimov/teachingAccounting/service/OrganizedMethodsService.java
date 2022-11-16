package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.OrganizedMethods;
import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.dto.OrganizedMethodsDto;
import me.anisimov.teachingAccounting.repository.OrganizedMethodsRepository;
import org.dozer.DozerBeanMapper;
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

    public OrganizedMethodsDto createOrganizedMethods(OrganizedMethodsDto organizedMethodsDto) {
        OrganizedMethods organizedMethods = new OrganizedMethods();
        organizedMethods.setId(organizedMethodsDto.getId());
        organizedMethods.setDate(organizedMethodsDto.getDate());
        organizedMethods.setResult(organizedMethodsDto.getResult());
        organizedMethods.setEventName(organizedMethodsDto.getEventName());
        organizedMethods.setEventLevel(organizedMethodsDto.getEventLevel());
        organizedMethods.setEventType(organizedMethodsDto.getEventType());
        organizedMethods.setStudentInformation(organizedMethodsDto.getStudentInformation());
        organizedMethods.setActivityType(organizedMethodsDto.getActivityType());
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
