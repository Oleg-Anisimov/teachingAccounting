package me.anisimov.teachingAccounting.controller;

import lombok.SneakyThrows;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.repository.UserRepository;
import me.anisimov.teachingAccounting.service.AcademicWorkService;
import me.anisimov.teachingAccounting.service.ExportToExcelService;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

//тестовый контроллер
@RestController
@RequestMapping("/test")
public class OperationController {

    @Autowired
    private ExportToExcelService exportToExcelService;

    @Autowired
    private AcademicWorkService academicWorkService;

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    @GetMapping
    public void test() throws IOException {

        User user = userRepository.findUserByLogin(SecurityUtils.getCurrentUsername());
        String[] fieldNames = {"id", "group.groupName"};

        List<AcademicWork> data = entityRepository.list(AcademicWork.class);

        exportToExcelService.export("test111.xls", fieldNames, data);

    }
}