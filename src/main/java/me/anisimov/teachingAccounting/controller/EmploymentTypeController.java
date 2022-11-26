package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.EmploymentType;
import me.anisimov.teachingAccounting.dto.EmploymentTypeDto;
import me.anisimov.teachingAccounting.service.EmploymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
@Api(value = "EmploymentTypeController",tags = {"Методы для работы с типами сотрудника"})
public class EmploymentTypeController {

    @Autowired
    private EmploymentTypeService employmentTypeService;

    @PostMapping("/create")
    public EmploymentTypeDto create(@RequestBody EmploymentTypeDto employmentTypeDto){
        return employmentTypeService.createEmploymentType(employmentTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        employmentTypeService.deleteEmploymentType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody EmploymentType employmentType){
        employmentTypeService.updateEmploymentType(employmentType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public EmploymentType getById(Long id){
        return employmentTypeService.getById(id);
    }

    @GetMapping()
    public List<EmploymentType> getAll(){
        return employmentTypeService.getAll();
    }
}
