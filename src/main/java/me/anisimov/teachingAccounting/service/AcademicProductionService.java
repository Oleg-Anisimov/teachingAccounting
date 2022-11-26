package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicProduction;
import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.repository.AcademicProductionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicProductionService {

    @Autowired
    private AcademicProductionRepository academicProductionRepository;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CabinetService cabinetService;
    @Autowired
    private AcademicWorkActivityTypeService academicWorkActivityTypeService;
    @Autowired
    private AcademicProductionActivityFormService academicProductionActivityFormService;

    public AcademicProductionDto createAcademicProduction(AcademicProductionDto academicProductionDto) {
        AcademicProduction academicProduction = new AcademicProduction();
        academicProduction.setId(academicProductionDto.getId());
        academicProduction.setDate(academicProductionDto.getDate());
        academicProduction.setResult(academicProductionDto.getResult());
        academicProduction.setAcademicProductionActivityForm(academicProductionActivityFormService.getById(academicProductionDto.getAcademicProductionActivityFormId()));
        academicProduction.setSpecialization(specializationService.getById(academicProductionDto.getSpecializationId()));
        academicProduction.setAcademicWorkActivityType(academicWorkActivityTypeService.getById(academicProductionDto.getAcademicWorkActivityTypeId()));
        academicProduction.setCabinet(cabinetService.getById(academicProductionDto.getCabinetId()));
        academicProductionRepository.save(academicProduction);
        return mapper.map(academicProduction, AcademicProductionDto.class);
    }

    public void deleteAcademicProduction(Long id) {
        academicProductionRepository.deleteById(id);
    }

    public void updateAcademicProduction(AcademicProduction academicProduction) {
        academicProductionRepository.save(academicProduction);
    }

    public AcademicProduction getById(Long id) {
        return academicProductionRepository.getReferenceById(id);
    }

    public List<AcademicProduction> getAll(){
        return academicProductionRepository.findAll();
    }
}

