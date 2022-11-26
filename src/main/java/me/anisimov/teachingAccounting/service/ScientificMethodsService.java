package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.ScientificMethods;
import me.anisimov.teachingAccounting.dto.ScientificMethodsDto;
import me.anisimov.teachingAccounting.repository.ScientificMethodsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ScientificMethodsService {

    @Autowired
    private ScientificMethodsRepository scientificMethodsRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ScientificActivityTypeService scientificActivityTypeService;
    @Autowired
    private EventLevelService eventLevelService;
    @Autowired
    private EventTypeService eventTypeService;
    @Autowired
    private ParticipationTypeService participationTypeService;

    public ScientificMethodsDto createScientificMethods(ScientificMethodsDto scientificMethodsDto) {
        ScientificMethods scientificMethods = new ScientificMethods();
        scientificMethods.setId(scientificMethodsDto.getId());
        scientificMethods.setDate(scientificMethodsDto.getDate());
        scientificMethods.setPlace(scientificMethodsDto.getPlace());
        scientificMethods.setEventName(scientificMethodsDto.getEventName());
        scientificMethods.setEventType(eventTypeService.getById(scientificMethodsDto.getEventTypeId()));
        scientificMethods.setResult(scientificMethodsDto.getResult());
        scientificMethods.setScientificActivityType(scientificActivityTypeService.getById(scientificMethodsDto.getScientificActivityTypeId()));
        scientificMethods.setEventLevel(eventLevelService.getById(scientificMethodsDto.getEventLevelId()));
        scientificMethods.setParticipationType(participationTypeService.getById(scientificMethodsDto.getParticipationTypeId()));
        scientificMethods.setStudentInformation(scientificMethodsDto.getStudentInformation());
        scientificMethodsRepository.save(scientificMethods);
        return mapper.map(scientificMethods,ScientificMethodsDto.class);
    }

    public void deleteScientificMethods(Long id) {
        scientificMethodsRepository.deleteById(id);
    }

    public void updateScientificMethods(ScientificMethods scientificMethods) {
        scientificMethodsRepository.save(scientificMethods);
    }

    public ScientificMethods getById(Long id) {
        return scientificMethodsRepository.getReferenceById(id);
    }

    public List<ScientificMethods> getAll() {
        return scientificMethodsRepository.findAll();
    }

}
