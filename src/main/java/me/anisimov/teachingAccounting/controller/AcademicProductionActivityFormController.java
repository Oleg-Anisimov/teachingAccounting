package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicProductionActivityForm;
import me.anisimov.teachingAccounting.domain.AcademicWorkActivityType;
import me.anisimov.teachingAccounting.dto.AcademicProductionActivityFormDto;
import me.anisimov.teachingAccounting.dto.AcademicWorkActivityTypeDto;
import me.anisimov.teachingAccounting.service.AcademicProductionActivityFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic_production_activity")
@Api(value = "AcademicProductionActivityFormController",tags = {"Методы для работы с видами УПД"})
public class AcademicProductionActivityFormController {

    @Autowired
    private AcademicProductionActivityFormService academicProductionActivityFormService;

    @PostMapping("/create")
    public AcademicProductionActivityFormDto create(@RequestBody AcademicProductionActivityFormDto academicProductionActivityFormDto){
        return academicProductionActivityFormService.createAcademicProductionActivityForm(academicProductionActivityFormDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        academicProductionActivityFormService.deleteAcademicProductionActivityForm(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicProductionActivityForm academicProductionActivityForm){
        academicProductionActivityFormService.updateAcademicProductionActivityForm(academicProductionActivityForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicProductionActivityForm getById(Long id){
        return academicProductionActivityFormService.getById(id);
    }

    @GetMapping()
    public List<AcademicProductionActivityForm> getAll(){
        return academicProductionActivityFormService.getAll();
    }
}
