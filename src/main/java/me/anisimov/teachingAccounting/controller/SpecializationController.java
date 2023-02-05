package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Specialization;
import me.anisimov.teachingAccounting.dto.SpecializationDto;
import me.anisimov.teachingAccounting.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialization")
@Api(value = "SpecializationController",tags = {"Методы для работы со специальностями"})
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @PostMapping("/create")
    public SpecializationDto create(@RequestBody SpecializationDto specializationDto) {
        return specializationService.createSpecialization(specializationDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        specializationService.deleteSpecialization(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Specialization specialization) {
        specializationService.updateSpecialization(specialization);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Specialization getById(Long id) {
        return specializationService.getById(id);
    }

    @GetMapping("/all")
    public List<Specialization> getAll() {
        return specializationService.getAll();
    }
}
