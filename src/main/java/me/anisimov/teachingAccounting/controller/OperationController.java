package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operate")
public class OperationController {
    @Autowired
    OperationService operationService;
    @GetMapping("/")
    public Teacher test() {
        return operationService.test();
    }
}