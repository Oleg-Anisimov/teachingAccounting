package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicMethodsActivityForm;
import me.anisimov.teachingAccounting.domain.AcademicProductionActivityForm;
import me.anisimov.teachingAccounting.dto.AcademicMethodsActivityFormDto;
import me.anisimov.teachingAccounting.dto.AcademicProductionActivityFormDto;
import me.anisimov.teachingAccounting.service.AcademicMethodsActivityFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic_methods_form")
@Api(value = "AcademicMethodsActivityFormController",tags = {"Методы для работы с видами УМД"})
public class AcademicMethodsActivityFormController {

    @Autowired
    private AcademicMethodsActivityFormService academicMethodsActivityFormService;

    @PostMapping("/create")
    public AcademicMethodsActivityFormDto create(@RequestBody AcademicMethodsActivityFormDto academicMethodsActivityFormDto){
        return academicMethodsActivityFormService.createAcademicMethodsActivityForm(academicMethodsActivityFormDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        academicMethodsActivityFormService.deleteAcademicMethodsActivityForm(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicMethodsActivityForm academicMethodsActivityForm){
        academicMethodsActivityFormService.updateAcademicMethodsActivityForm(academicMethodsActivityForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicMethodsActivityForm getById(Long id){
        return academicMethodsActivityFormService.getById(id);
    }

    @GetMapping()
    public List<AcademicMethodsActivityForm> getAll(){
        return academicMethodsActivityFormService.getAll();
    }
}
