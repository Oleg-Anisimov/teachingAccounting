package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.PromotionQualificationLevel;
import me.anisimov.teachingAccounting.dto.PromotionQualificationLevelDto;
import me.anisimov.teachingAccounting.service.PromotionQualificationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
public class PromotionQualificationLevelController {

    @Autowired
    PromotionQualificationLevelService promotionQualificationLevelService;

    @PostMapping("/create")
    public PromotionQualificationLevelDto create(@RequestBody PromotionQualificationLevelDto promotionQualificationLevelDto) {
        return promotionQualificationLevelService.createPromotionQualificationLevel(promotionQualificationLevelDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        promotionQualificationLevelService.deletePromotionQualificationLevel(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody PromotionQualificationLevel promotionQualificationLevel) {
        promotionQualificationLevelService.updatePromotionQualificationLevel(promotionQualificationLevel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public PromotionQualificationLevel getById(Long id) {
        return promotionQualificationLevelService.getById(id);
    }

    @GetMapping("/all")
    public List<PromotionQualificationLevel> getAll() {
        return promotionQualificationLevelService.getAll();
    }
}
