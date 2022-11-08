package me.anisimov.teachingAccounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operate")
public class OperationController {
    @GetMapping("/")
    public String test() {
        return "ok";
    }
}