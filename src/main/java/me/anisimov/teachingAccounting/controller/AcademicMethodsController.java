package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.service.AcademicMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/methods")
@Api(value = "TeacherController",tags = {"Методы для работы с учебно-методической работой"})
public class AcademicMethodsController {
    @Autowired
    private AcademicMethodsService academicMethodsService;

    @PostMapping("/create")
    public AcademicMethodsDto create(@RequestBody AcademicMethodsDto academicMethodsDto) {
        return academicMethodsService.createAcademicMethods(academicMethodsDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicMethodsService.deleteAcademicMethods(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicMethods academicMethods) {
        academicMethodsService.updateAcademicMethods(academicMethods);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicMethods getById(Long id) {
        return academicMethodsService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicMethodsDto> getAll() {
        return academicMethodsService.getAll();
    }

    @GetMapping()
    public List<AcademicMethodsDto> getCurrent(){
        return academicMethodsService.getCurrentAcademicMethods();
    }
}
