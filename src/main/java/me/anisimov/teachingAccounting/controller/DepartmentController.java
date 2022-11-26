package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Department;
import me.anisimov.teachingAccounting.dto.DepartmentDto;
import me.anisimov.teachingAccounting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Api(value = "TeacherController",tags = {"Методы для работы с отделениями"})
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public DepartmentDto create(@RequestBody DepartmentDto departmentDto){
        return departmentService.createDepartment(departmentDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Department department){
        departmentService.updateDepartment(department);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Department getById(Long id){
        return departmentService.getById(id);
    }

    @GetMapping()
    public List<Department> getAll(){
        return departmentService.getAll();
    }
}
