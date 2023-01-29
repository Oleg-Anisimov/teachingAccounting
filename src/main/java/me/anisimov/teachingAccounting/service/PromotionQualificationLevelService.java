package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.PromotionQualificationLevel;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.PromotionQualificationLevelDto;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.repository.PromotionQualificationLevelRepository;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PromotionQualificationLevelService {

    @Autowired
    private PromotionQualificationLevelRepository promotionQualificationLevelRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private ExportToExcelService exportToExcelService;
    @Autowired
    private EntityRepository entityRepository;

    public PromotionQualificationLevelDto createPromotionQualificationLevel(PromotionQualificationLevelDto promotionQualificationLevelDto) {

        Long userId = promotionQualificationLevelDto.getUserId();
        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        PromotionQualificationLevel promotionQualificationLevel = new PromotionQualificationLevel();
        promotionQualificationLevel.setUser(user);
        promotionQualificationLevel.setId(promotionQualificationLevelDto.getId());
        promotionQualificationLevel.setPromotionForm(promotionQualificationLevelDto.getPromotionForm());
        promotionQualificationLevel.setDate(promotionQualificationLevelDto.getDate());
        promotionQualificationLevel.setTopic(promotionQualificationLevelDto.getTopic());
        promotionQualificationLevel.setPlace(promotionQualificationLevelDto.getPlace());
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

    public List<PromotionQualificationLevelDto> getAll() {
        return promotionQualificationLevelRepository.findAll().stream()
                .map(entity -> mapper.map(entity,PromotionQualificationLevelDto.class))
                .collect(Collectors.toList());
    }

    public Page<PromotionQualificationLevelDto> getCurrentPromotionQualificationLevel(PageRequest pageRequest){
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        Page<PromotionQualificationLevelDto> allUserInformation = promotionQualificationLevelRepository.getAllByUser(user, pageRequest).map(promotion->{
            return mapper.map(promotion,PromotionQualificationLevelDto.class);
                });
        return allUserInformation;
    }

    public FileSystemResource exportToExcel() {

        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        List<PromotionQualificationLevel> promotionQualificationLevels = entityRepository.listForUser(PromotionQualificationLevel.class, user);

        String[] fieldNames = {
                "id", "promotionForm", "date",
                "place", "topic", "documentOrResult"
        };
        String filename = "PromotionQualificationLevel_" + LocalDate.now() + ".xlsx";

        exportToExcelService.export(filename, fieldNames, promotionQualificationLevels);

        return new FileSystemResource(new File(filename));

    }
}
