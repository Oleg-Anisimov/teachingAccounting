package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.ParticipationType;
import me.anisimov.teachingAccounting.dto.ParticipationTypeDto;
import me.anisimov.teachingAccounting.service.ParticipationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participation_type")
@Api(value = "ParticipationTypeController",tags = {"Методы для работы с видами участия"})
public class ParticipationTypeController {

    @Autowired
    private ParticipationTypeService participationTypeService;

    @PostMapping("/create")
    public ParticipationTypeDto create(@RequestBody ParticipationTypeDto participationTypeDto){
        return participationTypeService.createParticipationType(participationTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        participationTypeService.deleteParticipationType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody ParticipationType participationType){
        participationTypeService.updateParticipationType(participationType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public ParticipationType getById(Long id){
        return participationTypeService.getById(id);
    }

    @GetMapping()
    public List<ParticipationType> getAll(){
        return participationTypeService.getAll();
    }
}
