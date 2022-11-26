package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.EducateActivityType;
import me.anisimov.teachingAccounting.dto.EducateActivityTypeDto;
import me.anisimov.teachingAccounting.service.EducateActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educate_activity")
@Api(value = "EducateActivityTypeController",tags = {"Методы для работы с видами деятельности для воспитательной работы"})
public class EducateActivityTypeController {

    @Autowired
    private EducateActivityTypeService educateActivityTypeService;

    @PostMapping("/create")
    public EducateActivityTypeDto create(@RequestBody EducateActivityTypeDto educateActivityTypeDto){
        return educateActivityTypeService.createEducateActivityType(educateActivityTypeDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        educateActivityTypeService.deleteEducateActivityType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody EducateActivityType educateActivityType){
        educateActivityTypeService.updateEducateActivityType(educateActivityType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public EducateActivityType getById(Long id){
        return educateActivityTypeService.getById(id);
    }

    @GetMapping()
    public List<EducateActivityType> getAll(){
        return educateActivityTypeService.getAll();
    }
}
