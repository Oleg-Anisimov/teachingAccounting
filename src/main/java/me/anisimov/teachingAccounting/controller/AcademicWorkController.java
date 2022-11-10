package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.service.AcademicWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class AcademicWorkController {

    @Autowired
    private AcademicWorkService academicWorkService;

    @GetMapping("/create")
    public AcademicWorkDto create() {
        AcademicWorkDto academicWorkDto = new AcademicWorkDto();
        return academicWorkService.createAcademicWork(academicWorkDto);
    }
    @GetMapping("/delete")
    public ResponseEntity delete() {
        academicWorkService.deleteAcademicWork(202L);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/update")
    public ResponseEntity update() {
        academicWorkService.updateAcademicWork(academicWorkService.getById(153L));
        return ResponseEntity.ok().build();
    }
}
