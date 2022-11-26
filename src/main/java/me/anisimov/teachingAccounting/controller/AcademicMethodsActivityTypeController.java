package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicMethodsActivityType;
import me.anisimov.teachingAccounting.dto.AcademicMethodsActivityTypeDto;
import me.anisimov.teachingAccounting.service.AcademicMethodsActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic_methods_type")
@Api(value = "AcademicMethodsActivityFormController",tags = {"Методы для работы с типами УМД"})
public class AcademicMethodsActivityTypeController {

    @Autowired
    private AcademicMethodsActivityTypeService academicMethodsActivityTypeService;

    @PostMapping("/create")
    public AcademicMethodsActivityTypeDto create(@RequestBody AcademicMethodsActivityTypeDto academicMethodsActivityTypeDto){
        return academicMethodsActivityTypeService.createAcademicMethodsActivityType(academicMethodsActivityTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        academicMethodsActivityTypeService.deleteAcademicMethodsActivityType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicMethodsActivityType academicMethodsActivityType){
        academicMethodsActivityTypeService.updateAcademicMethodsActivityType(academicMethodsActivityType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicMethodsActivityType getById(Long id){
        return academicMethodsActivityTypeService.getById(id);
    }

    @GetMapping()
    public List<AcademicMethodsActivityType> getAll(){
        return academicMethodsActivityTypeService.getAll();
    }
}
