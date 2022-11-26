package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.WorkVector;
import me.anisimov.teachingAccounting.dto.WorkVectorDto;
import me.anisimov.teachingAccounting.service.WorkVectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vector")
@Api(value = "WorkVectorController",tags = {"Методы для работы с направлением работы"})
public class WorkVectorController {

    @Autowired
    private WorkVectorService workVectorService;

    @PostMapping("/create")
    public WorkVectorDto create(@RequestBody WorkVectorDto workVectorDto){
        return workVectorService.createWorkVector(workVectorDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        workVectorService.deleteWorkVector(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody WorkVector workVector){
        workVectorService.updateWorkVector(workVector);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public WorkVector getById(Long id){
        return workVectorService.getById(id);
    }

    @GetMapping()
    public List<WorkVector> getAll(){
        return workVectorService.getAll();
    }
}
