package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.EventLevel;
import me.anisimov.teachingAccounting.dto.EventLevelDto;
import me.anisimov.teachingAccounting.service.EventLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event_level")
@Api(value = "EventLevelController",tags = {"Методы для работы с уровнями мероприятия"})
public class EventLevelController {

    @Autowired
    private EventLevelService eventLevelService;

    @PostMapping("/create")
    public EventLevelDto create(@RequestBody EventLevelDto eventLevelDto){
        return eventLevelService.createEventLevel(eventLevelDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        eventLevelService.deleteEventLevel(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody EventLevel eventLevel){
        eventLevelService.updateEventLevel(eventLevel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public EventLevel getById(Long id){
        return eventLevelService.getById(id);
    }

    @GetMapping()
    public List<EventLevel> getAll(){
        return eventLevelService.getAll();
    }
}
