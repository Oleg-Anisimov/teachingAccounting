package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.service.AcademicWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class AcademicWorkController {

    @Autowired
    AcademicWorkService academicWorkService;

    @GetMapping("/create")
    public AcademicWorkDto create() {
        AcademicWorkDto academicWorkDto = new AcademicWorkDto();
        return academicWorkService.createAcademicWork(academicWorkDto);
    }
    @GetMapping("/delete")
    public String delete() {
        academicWorkService.deleteAcademicWork(202L);
        return "Поле удаленно";
    }
    @GetMapping("/update")
    public String update() {
        academicWorkService.updateAcademicWork(academicWorkService.getById(153L));
        return "Поле обновлено";
    }
}
