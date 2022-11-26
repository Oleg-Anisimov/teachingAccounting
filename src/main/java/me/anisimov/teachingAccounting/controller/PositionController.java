package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Category;
import me.anisimov.teachingAccounting.domain.Position;
import me.anisimov.teachingAccounting.dto.CategoryDto;
import me.anisimov.teachingAccounting.dto.PositionDto;
import me.anisimov.teachingAccounting.service.CategoryService;
import me.anisimov.teachingAccounting.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@Api(value = "PositionController",tags = {"Методы для работы с должностью"})
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/create")
    public PositionDto create(@RequestBody PositionDto positionDto){
        return positionService.createPosition(positionDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        positionService.deletePosition(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Position position){
        positionService.updatePosition(position);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Position getById(Long id){
        return positionService.getById(id);
    }

    @GetMapping()
    public List<Position> getAll(){
        return positionService.getAll();
    }
}
