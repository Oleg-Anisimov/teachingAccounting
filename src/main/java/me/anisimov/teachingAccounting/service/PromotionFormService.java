package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.PromotionForm;
import me.anisimov.teachingAccounting.dto.PromotionFormDto;
import me.anisimov.teachingAccounting.repository.PromotionFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PromotionFormService {

    @Autowired
    private PromotionFormRepository promotionFormRepository;
    @Autowired
    private ModelMapper mapper;

    public PromotionFormDto createPromotionForm(PromotionFormDto promotionFormDto){
        PromotionForm promotionForm = new PromotionForm();
        promotionForm.setName(promotionFormDto.getName());
        promotionForm.setId(promotionFormDto.getId());
        promotionFormRepository.save(promotionForm);
        return mapper.map(promotionForm,PromotionFormDto.class);
    }

    public void deletePromotionForm(Long id) {
        promotionFormRepository.deleteById(id);
    }

    public void updatePromotionForm(PromotionForm promotionForm) {
        promotionFormRepository.save(promotionForm);
    }

    public PromotionForm getById(Long id) {
        return promotionFormRepository.getReferenceById(id);
    }

    public List<PromotionForm> getAll() {
        return promotionFormRepository.findAll();
    }
}
