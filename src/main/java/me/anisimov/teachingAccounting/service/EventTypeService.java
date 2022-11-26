package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.EventType;
import me.anisimov.teachingAccounting.dto.EventTypeDto;
import me.anisimov.teachingAccounting.repository.EventTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public EventTypeDto createEventType(EventTypeDto eventTypeDto){
        EventType eventType = new EventType();
        eventType.setId(eventTypeDto.getId());
        eventType.setName(eventTypeDto.getName());
        eventTypeRepository.save(eventType);
        return mapper.map(eventType, EventTypeDto.class);
    }

    public void deleteEventType(Long id) {
        eventTypeRepository.deleteById(id);
    }

    public void updateEventType(EventType eventType) {
        eventTypeRepository.save(eventType);
    }

    public EventType getById(Long id) {
        return eventTypeRepository.getReferenceById(id);
    }

    public List<EventType> getAll() {
        return eventTypeRepository.findAll();
    }
}
