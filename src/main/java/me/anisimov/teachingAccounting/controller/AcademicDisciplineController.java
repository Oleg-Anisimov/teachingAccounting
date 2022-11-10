package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.dto.AcademicDisciplineDto;
import me.anisimov.teachingAccounting.service.AcademicDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discipline")
public class AcademicDisciplineController {

    @Autowired
    private AcademicDisciplineService academicDisciplineService;

    @GetMapping("/create")
    public AcademicDisciplineDto create() {
        AcademicDisciplineDto academicDisciplineDto = new AcademicDisciplineDto();
        return academicDisciplineService.createAcademicDiscipline(academicDisciplineDto);
    }
    @GetMapping("/delete")
    public ResponseEntity delete() {
        academicDisciplineService.deleteAcademicDiscipline(202L);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/update")
    public ResponseEntity update() {
        academicDisciplineService.updateAcademicDiscipline(academicDisciplineService.getById(153L));
        return ResponseEntity.ok().build();
    }
}
