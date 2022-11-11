package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.dto.EducateDto;
import me.anisimov.teachingAccounting.service.EducateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educate")
public class EducateController {

    @Autowired
    EducateService educateService;

    @PostMapping("/create")
    public EducateDto create(@RequestBody EducateDto departmentDto){
        return educateService.createEducate(departmentDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        educateService.deleteEducate(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Educate educate){
        educateService.updateEducate(educate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Educate getById(Long id){
        return educateService.getById(id);
    }

    @GetMapping("/all")
    public List<Educate> getAll(){
        return educateService.getAll();
    }
}
