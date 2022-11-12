package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.service.EnumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enum")
public class EnumController {

    @Autowired
    EnumsService enumsService;

    @GetMapping()
    public Map<String, List<String>> getAll(){
        return enumsService.getAll();
    }
}
