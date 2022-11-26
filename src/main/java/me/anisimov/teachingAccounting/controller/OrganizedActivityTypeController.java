package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.OrganizedActivityType;
import me.anisimov.teachingAccounting.dto.OrganizedActivityTypeDto;
import me.anisimov.teachingAccounting.service.OrganizedActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organized_activity")
@Api(value = "OrganizedActivityTypeController",tags = {"Методы для работы с видами деятельности для организационно-методической работы"})
public class OrganizedActivityTypeController {

    @Autowired
    private OrganizedActivityTypeService organizedActivityTypeService;

    @PostMapping("/create")
    public OrganizedActivityTypeDto create(@RequestBody OrganizedActivityTypeDto organizedActivityTypeDto){
        return organizedActivityTypeService.createOrganizedActivityType(organizedActivityTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        organizedActivityTypeService.deleteOrganizedActivityType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody OrganizedActivityType organizedActivityType){
        organizedActivityTypeService.updateOrganizedActivityType(organizedActivityType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public OrganizedActivityType getById(Long id){
        return organizedActivityTypeService.getById(id);
    }

    @GetMapping()
    public List<OrganizedActivityType> getAll(){
        return organizedActivityTypeService.getAll();
    }
}
