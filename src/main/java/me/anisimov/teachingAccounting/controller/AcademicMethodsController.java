package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.service.AcademicMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/methods")
public class AcademicMethodsController {
    @Autowired
    private AcademicMethodsService academicMethodsService;

    @PostMapping("/create")
    public AcademicMethodsDto create(AcademicMethodsDto academicMethodsDto) {
        return academicMethodsService.createAcademicMethods(academicMethodsDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicMethodsService.deleteAcademicMethods(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(AcademicMethods academicMethods) {
        academicMethodsService.updateAcademicMethods(academicMethods);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicMethods getById(Long id) {
        return academicMethodsService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicMethods> getAll() {
        return academicMethodsService.getAll();
    }
}
