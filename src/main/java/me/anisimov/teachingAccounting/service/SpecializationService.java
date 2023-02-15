package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.PlanAndFact;
import me.anisimov.teachingAccounting.domain.Specialization;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.dto.SpecializationDto;
import me.anisimov.teachingAccounting.repository.SpecializationRepository;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;
    @Autowired
    private ModelMapper mapper;

    public SpecializationDto createSpecialization(SpecializationDto specializationDto){
        Specialization specialization = new Specialization();
        specialization.setId(specializationDto.getId());
        specialization.setSpecialization(specializationDto.getSpecialization());
        specialization.setSpecializationName(specializationDto.getSpecializationName());
        specializationRepository.save(specialization);
        return mapper.map(specialization,SpecializationDto.class);
    }

    public void deleteSpecialization(Long id) {
        specializationRepository.deleteById(id);
    }

    public void updateSpecialization(SpecializationDto specializationDto) {

        Specialization specialization = specializationRepository.getReferenceById((specializationDto.getId()));
        specialization.setSpecialization(specializationDto.getSpecialization());
        specialization.setSpecializationName(specializationDto.getSpecializationName());
        specializationRepository.save(specialization);
    }

    public Specialization getById(Long id) {
        return specializationRepository.getReferenceById(id);
    }

    public List<Specialization> getAll() {
        return specializationRepository.findAll();
    }

}
