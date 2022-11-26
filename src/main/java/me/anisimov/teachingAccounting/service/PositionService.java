package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Position;
import me.anisimov.teachingAccounting.dto.PositionDto;
import me.anisimov.teachingAccounting.repository.PositionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ModelMapper mapper;

    public PositionDto createPosition(PositionDto positionDto){
        Position position = new Position();
        position.setName(positionDto.getName());
        position.setId(positionDto.getId());
        positionRepository.save(position);
        return mapper.map(position,PositionDto.class);
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }

    public void updatePosition(Position position) {
        positionRepository.save(position);
    }

    public Position getById(Long id) {
        return positionRepository.getReferenceById(id);
    }

    public List<Position> getAll() {
        return positionRepository.findAll();
    }
}
