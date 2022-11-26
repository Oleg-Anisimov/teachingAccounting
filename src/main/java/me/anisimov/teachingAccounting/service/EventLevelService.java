package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.EventLevel;
import me.anisimov.teachingAccounting.domain.OrganizedActivityType;
import me.anisimov.teachingAccounting.dto.EventLevelDto;
import me.anisimov.teachingAccounting.dto.OrganizedActivityTypeDto;
import me.anisimov.teachingAccounting.repository.EventLevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventLevelService {

    @Autowired
    private EventLevelRepository eventLevelRepository;
    @Autowired
    private ModelMapper mapper;

    public EventLevelDto createEventLevel(EventLevelDto eventLevelDto){
        EventLevel eventLevel = new EventLevel();
        eventLevel.setId(eventLevelDto.getId());
        eventLevel.setName(eventLevelDto.getName());
        eventLevelRepository.save(eventLevel);
        return mapper.map(eventLevel, EventLevelDto.class);
    }

    public void deleteEventLevel(Long id) {
        eventLevelRepository.deleteById(id);
    }

    public void updateEventLevel(EventLevel eventLevel) {
        eventLevelRepository.save(eventLevel);
    }

    public EventLevel getById(Long id) {
        return eventLevelRepository.getReferenceById(id);
    }

    public List<EventLevel> getAll() {
        return eventLevelRepository.findAll();
    }
}
