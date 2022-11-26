package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicWorkActivityType;
import me.anisimov.teachingAccounting.dto.AcademicWorkActivityTypeDto;
import me.anisimov.teachingAccounting.service.AcademicWorkActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic_activity")
@Api(value = "AcademicWorkActivityTypeController",tags = {"Методы для работы с видами деятельности для учебно методической/производственной работы"})
public class AcademicWorkActivityTypeController {

    @Autowired
    private AcademicWorkActivityTypeService academicWorkActivityTypeService;

    @PostMapping("/create")
    public AcademicWorkActivityTypeDto create(@RequestBody AcademicWorkActivityTypeDto academicWorkActivityTypeDto){
        return academicWorkActivityTypeService.createAcademicWorkActivityType(academicWorkActivityTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        academicWorkActivityTypeService.deleteAcademicWorkActivityType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicWorkActivityType academicWorkActivityType){
        academicWorkActivityTypeService.updateAcademicWorkActivityType(academicWorkActivityType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicWorkActivityType getById(Long id){
        return academicWorkActivityTypeService.getById(id);
    }

    @GetMapping()
    public List<AcademicWorkActivityType> getAll(){
        return academicWorkActivityTypeService.getAll();
    }
}
