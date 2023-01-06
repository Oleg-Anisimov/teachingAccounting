package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.PromotionQualificationLevel;
import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.dto.EducateDto;
import me.anisimov.teachingAccounting.dto.PromotionQualificationLevelDto;
import me.anisimov.teachingAccounting.service.PromotionQualificationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
@Api(value = "TeacherController",tags = {"Методы для работы с повышением уровня квалификации"})
public class PromotionQualificationLevelController {

    @Autowired
    private PromotionQualificationLevelService promotionQualificationLevelService;

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
    public List<PromotionQualificationLevelDto> getAll() {
        return promotionQualificationLevelService.getAll();
    }

    @PostMapping()
    public Page<PromotionQualificationLevelDto> getCurrent(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return promotionQualificationLevelService.getCurrentPromotionQualificationLevel(pageRequest);
    }
}
