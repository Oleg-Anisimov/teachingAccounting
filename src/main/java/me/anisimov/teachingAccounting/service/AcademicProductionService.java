package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicProduction;
import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.repository.AcademicProductionRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AcademicProductionService {

    @Autowired
    AcademicProductionRepository academicProductionRepository;
    @Autowired
    DozerBeanMapper mapper;

    public AcademicProductionDto createAcademicProduction(AcademicProductionDto academicProductionDto){
        AcademicProduction academicProduction = new AcademicProduction();
        academicProduction.setId(academicProductionDto.getId());
        academicProduction.setDate(academicProductionDto.getDate());
        academicProduction.setResult(academicProductionDto.getResult());
        academicProduction.setAcademicMethodActivityForm(academicProductionDto.getAcademicMethodActivityForm());
        academicProduction.setSpecialization(academicProductionDto.getSpecialization());
        academicProduction.setActivityType(academicProductionDto.getActivityType());
        academicProduction.setCabinetType(academicProductionDto.getCabinetType());
        academicProduction.setCabinetName(academicProductionDto.getCabinetName());
        academicProductionRepository.save(academicProduction);
        return mapper.map(academicProduction,AcademicProductionDto.class);
    }

    public void deleteAcademicProduction(Long id){
        academicProductionRepository.deleteById(id);
    }
    public void updateAcademicProduction(AcademicProduction academicProduction){
        academicProductionRepository.save(academicProduction);
    }

    public AcademicProduction getById(Long id){
        return academicProductionRepository.getReferenceById(id);
    }
}

