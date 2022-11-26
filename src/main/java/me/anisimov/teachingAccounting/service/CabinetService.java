package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Cabinet;
import me.anisimov.teachingAccounting.dto.CabinetDto;
import me.anisimov.teachingAccounting.repository.CabinetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CabinetService {

    @Autowired
    private CabinetRepository cabinetRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CabinetTypeService cabinetTypeService;

    public CabinetDto createCabinet(CabinetDto cabinetDto) {
        Cabinet cabinet = new Cabinet();
        cabinet.setId(cabinetDto.getId());
        cabinet.setCabinets(cabinetTypeService.getById(cabinetDto.getCabinetId()));
        cabinet.setCabinetName(cabinetDto.getCabinetName());
        cabinetRepository.save(cabinet);
        return mapper.map(cabinet, CabinetDto.class);
    }

    public void deleteCabinet(Long id) {
        cabinetRepository.deleteById(id);
    }

    public void updateCabinet(Cabinet cabinet) {
        cabinetRepository.save(cabinet);
    }

    public Cabinet getById(Long id) {
        return cabinetRepository.getReferenceById(id);
    }

    public List<Cabinet> getAll() {
        return cabinetRepository.findAll();
    }
}
