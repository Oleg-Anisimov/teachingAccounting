package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.dto.AcademicDisciplineDto;
import me.anisimov.teachingAccounting.service.AcademicDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discipline")
public class AcademicDisciplineController {

    @Autowired
    AcademicDisciplineService academicDisciplineService;

    @GetMapping("/create")
    public AcademicDisciplineDto create() {
        AcademicDisciplineDto academicDisciplineDto = new AcademicDisciplineDto();
        return academicDisciplineService.createAcademicDiscipline(academicDisciplineDto);
    }
    @GetMapping("/delete")
    public String delete() {
        academicDisciplineService.deleteAcademicDiscipline(202L);
        return "Поле удаленно";
    }
    @GetMapping("/update")
    public String update() {
        academicDisciplineService.updateAcademicDiscipline(academicDisciplineService.getById(153L));
        return "Поле обновлено";
    }
}
