package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.PromotionQualificationLevel;
import me.anisimov.teachingAccounting.dto.PromotionQualificationLevelDto;
import me.anisimov.teachingAccounting.repository.PromotionQualificationLevelRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PromotionQualificationLevelService {

    @Autowired
    PromotionQualificationLevelRepository promotionQualificationLevelRepository;
    @Autowired
    DozerBeanMapper mapper;

    public PromotionQualificationLevelDto createPromotionQualificationLevel(PromotionQualificationLevelDto promotionQualificationLevelDto) {
        PromotionQualificationLevel promotionQualificationLevel = new PromotionQualificationLevel();
        promotionQualificationLevel.setId(promotionQualificationLevelDto.getId());
        promotionQualificationLevel.setPromotionForm(promotionQualificationLevelDto.getPromotionForm());
        promotionQualificationLevel.setDate(promotionQualificationLevelDto.getDate());
        promotionQualificationLevel.setTopic(promotionQualificationLevelDto.getTopic());
        promotionQualificationLevel.setDocumentOrResult(promotionQualificationLevelDto.getDocumentOrResult());
        promotionQualificationLevelRepository.save(promotionQualificationLevel);
        return mapper.map(promotionQualificationLevel, PromotionQualificationLevelDto.class);
    }

    public void deletePromotionQualificationLevel(Long id) {
        promotionQualificationLevelRepository.deleteById(id);
    }

    public void updatePromotionQualificationLevel(PromotionQualificationLevel promotionQualificationLevel) {
        promotionQualificationLevelRepository.save(promotionQualificationLevel);
    }

    public PromotionQualificationLevel getById(Long id) {
        return promotionQualificationLevelRepository.getReferenceById(id);
    }

    public List<PromotionQualificationLevel> getAll() {
        return promotionQualificationLevelRepository.findAll();
    }
}
