package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Position;
import me.anisimov.teachingAccounting.domain.PromotionForm;
import me.anisimov.teachingAccounting.dto.PositionDto;
import me.anisimov.teachingAccounting.dto.PromotionFormDto;
import me.anisimov.teachingAccounting.service.PromotionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion_form")
@Api(value = "PromotionFormController",tags = {"Методы для работы с формами поышения квалификации"})
public class PromotionFormController {

    @Autowired
    private PromotionFormService promotionFormService;

    @PostMapping("/create")
    public PromotionFormDto create(@RequestBody PromotionFormDto promotionFormDto){
        return promotionFormService.createPromotionForm(promotionFormDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        promotionFormService.deletePromotionForm(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody PromotionForm promotionForm){
        promotionFormService.updatePromotionForm(promotionForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public PromotionForm getById(Long id){
        return promotionFormService.getById(id);
    }

    @GetMapping()
    public List<PromotionForm> getAll(){
        return promotionFormService.getAll();
    }
}
