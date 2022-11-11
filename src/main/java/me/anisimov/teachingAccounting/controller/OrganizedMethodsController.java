package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.OrganizedMethods;
import me.anisimov.teachingAccounting.dto.OrganizedMethodsDto;
import me.anisimov.teachingAccounting.service.OrganizedMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organized")
public class OrganizedMethodsController {

    @Autowired
    OrganizedMethodsService organizedMethodsService;

    @PostMapping("/create")
    public OrganizedMethodsDto create(@RequestBody OrganizedMethodsDto organizedMethodsDto) {
        return organizedMethodsService.createOrganizedMethods(organizedMethodsDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        organizedMethodsService.deleteOrganizedMethods(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody OrganizedMethods organizedMethods) {
        organizedMethodsService.updateOrganizedMethods(organizedMethods);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public OrganizedMethods getById(Long id) {
        return organizedMethodsService.getById(id);
    }

    @GetMapping("/all")
    public List<OrganizedMethods> getAll() {
        return organizedMethodsService.getAll();
    }
}
