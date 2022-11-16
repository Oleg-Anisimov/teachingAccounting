package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.ScientificMethods;
import me.anisimov.teachingAccounting.dto.ScientificMethodsDto;
import me.anisimov.teachingAccounting.repository.ScientificMethodsRepository;
import org.dozer.DozerBeanMapper;
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

    public ScientificMethodsDto createScientificMethods(ScientificMethodsDto scientificMethodsDto) {
        ScientificMethods scientificMethods = new ScientificMethods();
        scientificMethods.setId(scientificMethodsDto.getId());
        scientificMethods.setDate(scientificMethodsDto.getDate());
        scientificMethods.setPlace(scientificMethodsDto.getPlace());
        scientificMethods.setEventName(scientificMethodsDto.getEventName());
        scientificMethods.setEventType(scientificMethodsDto.getEventType());
        scientificMethods.setResult(scientificMethodsDto.getResult());
        scientificMethods.setActivityType(scientificMethodsDto.getActivityType());
        scientificMethods.setEventLevel(scientificMethodsDto.getEventLevel());
        scientificMethods.setParticipationType(scientificMethodsDto.getParticipationType());
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
