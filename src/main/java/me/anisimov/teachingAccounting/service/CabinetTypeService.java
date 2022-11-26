package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.CabinetType;
import me.anisimov.teachingAccounting.dto.CabinetTypeDto;
import me.anisimov.teachingAccounting.repository.CabinetTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CabinetTypeService {

    @Autowired
    private CabinetTypeRepository cabinetTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public CabinetTypeDto createCabinetType(CabinetTypeDto cabinetTypeDto){
        CabinetType cabinetType = new CabinetType();
        cabinetType.setId(cabinetTypeDto.getId());
        cabinetType.setName(cabinetTypeDto.getName());
        cabinetTypeRepository.save(cabinetType);
        return mapper.map(cabinetType,CabinetTypeDto.class);
    }

    public void deleteCabinetType(Long id) {
        cabinetTypeRepository.deleteById(id);
    }

    public void updateCabinetType(CabinetType cabinetType) {
        cabinetTypeRepository.save(cabinetType);
    }

    public CabinetType getById(Long id) {
        return cabinetTypeRepository.getReferenceById(id);
    }

    public List<CabinetType> getAll() {
        return cabinetTypeRepository.findAll();
    }
}
