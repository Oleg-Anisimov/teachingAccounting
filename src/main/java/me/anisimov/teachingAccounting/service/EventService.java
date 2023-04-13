package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Event;
import me.anisimov.teachingAccounting.dto.EventDto;
import me.anisimov.teachingAccounting.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper mapper;

    public EventDto create(EventDto eventDto){
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setEventName(eventDto.getEventName());
        event.setEventLevel(eventDto.getEventLevel());
        event.setEventType(eventDto.getEventType());
        eventRepository.save(event);
        return mapper.map(event, EventDto.class);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    public void update(Event event) {
        eventRepository.save(event);
    }

    public Event getById(Long id) {
        return eventRepository.getReferenceById(id);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}
