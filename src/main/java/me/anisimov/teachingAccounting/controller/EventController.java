package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Event;
import me.anisimov.teachingAccounting.dto.EventDto;
import me.anisimov.teachingAccounting.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@Api(value = "EventController",tags = {"Методы для работы с мероприятиями"})
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public EventDto create(@RequestBody EventDto eventDto){
        return eventService.create(eventDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        eventService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Event event){
        eventService.update(event);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Event getById(Long id){
        return eventService.getById(id);
    }

    @GetMapping("/all")
    public List<Event> getAll(){
        return eventService.getAll();
    }
}
