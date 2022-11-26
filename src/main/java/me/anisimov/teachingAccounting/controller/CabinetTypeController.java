package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.CabinetType;
import me.anisimov.teachingAccounting.dto.CabinetTypeDto;
import me.anisimov.teachingAccounting.service.CabinetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabinet_type")
@Api(value = "CabinetTypeController",tags = {"Методы для работы с типами кабинетов"})
public class CabinetTypeController {

    @Autowired
    private CabinetTypeService cabinetTypeService;

    @PostMapping("/create")
    public CabinetTypeDto create(@RequestBody CabinetTypeDto cabinetTypeDto){
        return cabinetTypeService.createCabinetType(cabinetTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        cabinetTypeService.deleteCabinetType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody CabinetType cabinetType){
        cabinetTypeService.updateCabinetType(cabinetType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public CabinetType getById(Long id){
        return cabinetTypeService.getById(id);
    }

    @GetMapping()
    public List<CabinetType> getAll(){
        return cabinetTypeService.getAll();
    }
}
