package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.OrganizedMethods;
import me.anisimov.teachingAccounting.dto.OrganizedMethodsDto;
import me.anisimov.teachingAccounting.service.OrganizedMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organized")
@Api(value = "TeacherController",tags = {"Методы для работы с организационно-методическими работами"})
public class OrganizedMethodsController {

    @Autowired
    private OrganizedMethodsService organizedMethodsService;

    @PostMapping("/create")
    public OrganizedMethodsDto create(@RequestBody OrganizedMethodsDto organizedMethodsDto) {
        return organizedMethodsService.createOrganizedMethods(organizedMethodsDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        organizedMethodsService.deleteOrganizedMethods(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody OrganizedMethods organizedMethods) {
        organizedMethodsService.updateOrganizedMethods(organizedMethods);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public OrganizedMethods getById(Long id) {
        return organizedMethodsService.getById(id);
    }

    @GetMapping("/all")
    public List<OrganizedMethodsDto> getAll() {
        return organizedMethodsService.getAll();
    }

    @GetMapping()
    public Page<OrganizedMethodsDto> getCurrent(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return organizedMethodsService.getCurrentOrganizedMethods(pageRequest);
    }
}
