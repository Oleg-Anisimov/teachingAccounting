package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.service.AcademicMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methods")
public class AcademicMethodsController {
    @Autowired
    private AcademicMethodsService academicMethodsService;

    @GetMapping("/create")
    public AcademicMethodsDto create() {
        AcademicMethodsDto academicMethodsDto = new AcademicMethodsDto();
        return academicMethodsService.createAcademicMethods(academicMethodsDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete() {
        academicMethodsService.deleteAcademicMethods(202L);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/update")
    public ResponseEntity update() {
        academicMethodsService.updateAcademicMethods(academicMethodsService.getById(153L));
        return ResponseEntity.ok().build();
    }
}
