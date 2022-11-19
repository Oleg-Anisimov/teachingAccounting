package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//тестовый контроллер
@RestController
@RequestMapping("/test1")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok().build();
    }
}