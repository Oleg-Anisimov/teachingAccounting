package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.service.AcademicProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/production")
public class AcademicProductionController {

    @Autowired
    private AcademicProductionService academicProductionService;

    @GetMapping("/create")
    public AcademicProductionDto create() {
        AcademicProductionDto academicProductionDto = new AcademicProductionDto();
        return academicProductionService.createAcademicProduction(academicProductionDto);
    }
    @GetMapping("/delete")
    public ResponseEntity delete() {
        academicProductionService.deleteAcademicProduction(202L);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/update")
    public ResponseEntity update() {
        academicProductionService.updateAcademicProduction(academicProductionService.getById(153L));
        return ResponseEntity.ok().build();
    }
}
