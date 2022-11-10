package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.service.AcademicProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/production")
public class AcademicProductionController {

    @Autowired
    AcademicProductionService academicProductionService;

    @GetMapping("/create")
    public AcademicProductionDto create() {
        AcademicProductionDto academicProductionDto = new AcademicProductionDto();
        return academicProductionService.createAcademicProduction(academicProductionDto);
    }
    @GetMapping("/delete")
    public String delete() {
        academicProductionService.deleteAcademicProduction(202L);
        return "Поле удаленно";
    }
    @GetMapping("/update")
    public String update() {
        academicProductionService.updateAcademicProduction(academicProductionService.getById(153L));
        return "Поле обновлено";
    }
}
