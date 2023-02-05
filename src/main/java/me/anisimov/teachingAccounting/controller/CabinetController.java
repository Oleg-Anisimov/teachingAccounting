package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Cabinet;
import me.anisimov.teachingAccounting.domain.Specialization;
import me.anisimov.teachingAccounting.dto.CabinetDto;
import me.anisimov.teachingAccounting.dto.SpecializationDto;
import me.anisimov.teachingAccounting.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabinet")
@Api(value = "CabinetController",tags = {"Методы для работы с кабинетами"})
public class CabinetController {

    @Autowired
    private CabinetService cabinetService;

    @PostMapping("/create")
    public CabinetDto create(@RequestBody CabinetDto cabinetDto) {
        return cabinetService.createCabinet(cabinetDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        cabinetService.deleteCabinet(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Cabinet cabinet) {
        cabinetService.updateCabinet(cabinet);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Cabinet getById(Long id) {
        return cabinetService.getById(id);
    }

    @GetMapping("/all")
    public List<Cabinet> getAll() {
        return cabinetService.getAll();
    }
}