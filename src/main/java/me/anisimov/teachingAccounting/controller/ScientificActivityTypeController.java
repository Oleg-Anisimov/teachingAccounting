package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.ScientificActivityType;
import me.anisimov.teachingAccounting.dto.ScientificActivityTypeDto;
import me.anisimov.teachingAccounting.service.ScientificActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ScientificActivityTypeController {

    @Autowired
    private ScientificActivityTypeService scientificActivityTypeService;

    @PostMapping("/create")
    public ScientificActivityTypeDto create(@RequestBody ScientificActivityTypeDto scientificActivityTypeDto){
        return scientificActivityTypeService.createScientificActivityType(scientificActivityTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        scientificActivityTypeService.deleteScientificActivityType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody ScientificActivityType scientificActivityType){
        scientificActivityTypeService.updateScientificActivityType(scientificActivityType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public ScientificActivityType getById(Long id){
        return scientificActivityTypeService.getById(id);
    }

    @GetMapping()
    public List<ScientificActivityType> getAll(){
        return scientificActivityTypeService.getAll();
    }
}
