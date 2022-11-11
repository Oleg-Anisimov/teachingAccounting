package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.service.AcademicWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
public class AcademicWorkController {

    @Autowired
    private AcademicWorkService academicWorkService;

    @PostMapping("/create")
    public AcademicWorkDto create(@RequestBody AcademicWorkDto academicWorkDto) {
        return academicWorkService.createAcademicWork(academicWorkDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicWorkService.deleteAcademicWork(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicWork academicWork) {
        academicWorkService.updateAcademicWork(academicWork);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicWork getById(Long id) {
        return academicWorkService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicWork> getAll() {
        return academicWorkService.getAll();
    }
}
