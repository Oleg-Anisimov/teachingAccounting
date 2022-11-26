package me.anisimov.teachingAccounting.service;

import liquibase.pro.packaged.W;
import lombok.extern.slf4j.Slf4j;

import me.anisimov.teachingAccounting.domain.Category;
import me.anisimov.teachingAccounting.domain.WorkVector;
import me.anisimov.teachingAccounting.dto.WorkVectorDto;
import me.anisimov.teachingAccounting.repository.WorkVectorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkVectorService {

    @Autowired
    private WorkVectorRepository workVectorRepository;
    @Autowired
    private ModelMapper mapper;

    public WorkVectorDto createWorkVector(WorkVectorDto workVectorDto){
        WorkVector workVector = new WorkVector();
        workVector.setId(workVectorDto.getId());
        workVector.setName(workVectorDto.getName());
        workVectorRepository.save(workVector);
        return mapper.map(workVector, WorkVectorDto.class);
    }

    public void deleteWorkVector(Long id) {
        workVectorRepository.deleteById(id);
    }

    public void updateWorkVector(WorkVector workVector) {
        workVectorRepository.save(workVector);
    }

    public WorkVector getById(Long id) {
        return workVectorRepository.getReferenceById(id);
    }

    public List<WorkVector> getAll() {
        return workVectorRepository.findAll();
    }
}
