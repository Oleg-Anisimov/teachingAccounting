package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicProductionActivityForm;
import me.anisimov.teachingAccounting.domain.AcademicWorkActivityType;
import me.anisimov.teachingAccounting.dto.AcademicProductionActivityFormDto;
import me.anisimov.teachingAccounting.dto.AcademicWorkActivityTypeDto;
import me.anisimov.teachingAccounting.repository.AcademicProductionActivityFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class AcademicProductionActivityFormService {

    @Autowired
    private AcademicProductionActivityFormRepository academicProductionActivityFormRepository;
    @Autowired
    private ModelMapper mapper;

    public AcademicProductionActivityFormDto createAcademicProductionActivityForm(AcademicProductionActivityFormDto academicProductionActivityFormDto){
        AcademicProductionActivityForm academicProductionActivityForm = new AcademicProductionActivityForm();
        academicProductionActivityForm.setId(academicProductionActivityFormDto.getId());
        academicProductionActivityForm.setName(academicProductionActivityFormDto.getName());
        academicProductionActivityFormRepository.save(academicProductionActivityForm);
        return mapper.map(academicProductionActivityForm, AcademicProductionActivityFormDto.class);
    }

    public void deleteAcademicProductionActivityForm(Long id) {
        academicProductionActivityFormRepository.deleteById(id);
    }

    public void updateAcademicProductionActivityForm(AcademicProductionActivityForm academicProductionActivityForm) {
        academicProductionActivityFormRepository.save(academicProductionActivityForm);
    }

    public AcademicProductionActivityForm getById(Long id) {
        return academicProductionActivityFormRepository.getReferenceById(id);
    }

    public List<AcademicProductionActivityForm> getAll() {
        return academicProductionActivityFormRepository.findAll();
    }
}
