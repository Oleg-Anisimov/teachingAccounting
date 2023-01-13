package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.repository.AcademicWorkRepository;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.repository.UserRepository;
import me.anisimov.teachingAccounting.service.AcademicWorkService;
import me.anisimov.teachingAccounting.service.ExportToExcelService;
import me.anisimov.teachingAccounting.service.OperationService;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//тестовый контроллер
@RestController
@RequestMapping("/test")
public class OperationController {

    @Autowired
    private ExportToExcelService exportToExcelService;

    @Autowired
    private AcademicWorkService academicWorkService;

    @GetMapping
    public void test() throws IOException {

        exportToExcelService.export("test111.xls", AcademicWorkDto.class, academicWorkService.getAll());

    }
}