package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicDiscipline;
import me.anisimov.teachingAccounting.dto.AcademicDisciplineDto;
import me.anisimov.teachingAccounting.repository.AcademicDisciplineRepository;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicDisciplineService {
    @Autowired
    private AcademicDisciplineRepository academicDisciplineRepository;
    @Autowired
    private ModelMapper mapper;

    public AcademicDisciplineDto createAcademicDiscipline(AcademicDisciplineDto academicDisciplineDto) {
        AcademicDiscipline academicDiscipline = new AcademicDiscipline();
        academicDiscipline.setDisciplineNumber(academicDisciplineDto.getDisciplineNumber());
        academicDiscipline.setName(academicDisciplineDto.getName());
        academicDiscipline = academicDisciplineRepository.save(academicDiscipline);
        return mapper.map(academicDiscipline, AcademicDisciplineDto.class);
    }

    public void deleteAcademicDiscipline(Long id) {
        academicDisciplineRepository.deleteById(id);
    }

    public void updateAcademicDiscipline(AcademicDisciplineDto academicDisciplineDto) {

        AcademicDiscipline academicDiscipline = academicDisciplineRepository.getReferenceById((academicDisciplineDto.getId()));
        academicDiscipline.setDisciplineNumber(academicDisciplineDto.getDisciplineNumber());
        academicDiscipline.setName(academicDiscipline.getName());
        academicDisciplineRepository.save(academicDiscipline);
    }

    public AcademicDiscipline getById(Long id) {
        return academicDisciplineRepository.getReferenceById(id);
    }

    public List<AcademicDiscipline> getAll(){
        return academicDisciplineRepository.findAll();
    }

}
