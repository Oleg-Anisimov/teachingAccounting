package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.dto.EducateDto;
import me.anisimov.teachingAccounting.repository.EducateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EducateService {

    @Autowired
    private EducateRepository educateRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private WorkVectorService workVectorService;
    @Autowired
    private EducateActivityTypeService educateActivityTypeService;
    @Autowired
    private EventLevelService eventLevelService;
    @Autowired
    private EventTypeService eventTypeService;

    public EducateDto createEducate(EducateDto educateDto) {
        Educate educate = new Educate();
        educate.setId(educateDto.getId());
        educate.setDate(educateDto.getDate());
        educate.setResult(educateDto.getResult());
        educate.setEventType(eventTypeService.getById(educateDto.getEventTypeId()));
        educate.setEventName(educateDto.getEventName());
        educate.setEventLevel(eventLevelService.getById(educateDto.getEventLevelId()));
        educate.setActivityType(educateActivityTypeService.getById(educateDto.getEducateActivityTypeId()));
        educate.setStudentInformation(educateDto.getStudentInformation());
        educate.setWorkVector(workVectorService.getById(educateDto.getWorkVectorId()));
        educateRepository.save(educate);
        return mapper.map(educate, EducateDto.class);
    }

    public void deleteEducate(Long id) {
        educateRepository.deleteById(id);
    }

    public void updateEducate(Educate educate) {
        educateRepository.save(educate);
    }

    public Educate getById(Long id) {
        return educateRepository.getReferenceById(id);
    }

    public List<Educate> getAll() {
        return educateRepository.findAll();
    }
}
