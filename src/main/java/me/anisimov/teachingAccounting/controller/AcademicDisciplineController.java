package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicDiscipline;
import me.anisimov.teachingAccounting.dto.AcademicDisciplineDto;
import me.anisimov.teachingAccounting.service.AcademicDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
@Api(value = "TeacherController", tags = {"Методы для работы с учебной дисциплиной"})
public class AcademicDisciplineController {

    @Autowired
    private AcademicDisciplineService academicDisciplineService;

    @PostMapping("/create")
    public AcademicDisciplineDto create(@RequestBody AcademicDisciplineDto academicDisciplineDto) {
        return academicDisciplineService.createAcademicDiscipline(academicDisciplineDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicDisciplineService.deleteAcademicDiscipline(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicDiscipline academicDiscipline) {
        academicDisciplineService.updateAcademicDiscipline(academicDiscipline);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicDiscipline getById(Long id) {
        return academicDisciplineService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicDiscipline> getAll() {
        return academicDisciplineService.getAll();
    }
}
