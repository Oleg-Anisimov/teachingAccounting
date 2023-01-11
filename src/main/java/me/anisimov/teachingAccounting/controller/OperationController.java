package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.repository.UserRepository;
import me.anisimov.teachingAccounting.service.OperationService;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//тестовый контроллер
@RestController
@RequestMapping("/test")
public class OperationController {

    @Autowired
    private OperationService operationService;
    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public ResponseEntity test() {

        String currentUsername = SecurityUtils.getCurrentUsername();
        User user = userRepository.findUserByLogin(currentUsername);
        List<AcademicWork> academicWorks = entityRepository.listForUser(AcademicWork.class, user);
        return ResponseEntity.ok(academicWorks);
    }
}