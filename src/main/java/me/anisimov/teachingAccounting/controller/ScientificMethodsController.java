package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.ScientificMethods;
import me.anisimov.teachingAccounting.dto.ScientificMethodsDto;
import me.anisimov.teachingAccounting.service.ScientificMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scientific")
public class ScientificMethodsController {

    @Autowired
    ScientificMethodsService scientificMethodsService;

    @PostMapping("/create")
    public ScientificMethodsDto create(@RequestBody ScientificMethodsDto scientificMethods) {
        return scientificMethodsService.createScientificMethods(scientificMethods);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        scientificMethodsService.deleteScientificMethods(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody ScientificMethods scientificMethods) {
        scientificMethodsService.updateScientificMethods(scientificMethods);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public ScientificMethods getById(Long id) {
        return scientificMethodsService.getById(id);
    }

    @GetMapping("/all")
    public List<ScientificMethods> getAll() {
        return scientificMethodsService.getAll();
    }
}
