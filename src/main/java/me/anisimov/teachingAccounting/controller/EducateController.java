package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.dto.EducateDto;
import me.anisimov.teachingAccounting.service.EducateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educate")
@Api(value = "TeacherController",tags = {"Методы для работы с воспитательной работой"})
public class EducateController {

    @Autowired
    private EducateService educateService;

    @PostMapping("/create")
    public EducateDto create(@RequestBody EducateDto educateDto){
        return educateService.createEducate(educateDto);
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
    public List<EducateDto> getAll(){
        return educateService.getAll();
    }

    @PostMapping()
    public List<EducateDto> getCurrent(){
        return educateService.getCurrentEducate();
    }
}
