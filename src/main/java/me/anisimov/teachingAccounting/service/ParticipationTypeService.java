package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.ParticipationType;
import me.anisimov.teachingAccounting.domain.Position;
import me.anisimov.teachingAccounting.dto.ParticipationTypeDto;
import me.anisimov.teachingAccounting.dto.PositionDto;
import me.anisimov.teachingAccounting.repository.ParticipationTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ParticipationTypeService {

    @Autowired
    private ParticipationTypeRepository participationTypeRepository;
    @Autowired
    private ModelMapper mapper;

    public ParticipationTypeDto createParticipationType(ParticipationTypeDto participationTypeDto){
        ParticipationType participationType = new ParticipationType();
        participationType.setName(participationTypeDto.getName());
        participationType.setId(participationTypeDto.getId());
        participationTypeRepository.save(participationType);
        return mapper.map(participationType,ParticipationTypeDto.class);
    }

    public void deleteParticipationType(Long id) {
        participationTypeRepository.deleteById(id);
    }

    public void updateParticipationType(ParticipationType participationType) {
        participationTypeRepository.save(participationType);
    }

    public ParticipationType getById(Long id) {
        return participationTypeRepository.getReferenceById(id);
    }

    public List<ParticipationType> getAll() {
        return participationTypeRepository.findAll();
    }
}
