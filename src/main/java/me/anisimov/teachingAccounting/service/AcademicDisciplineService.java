package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicDiscipline;
import me.anisimov.teachingAccounting.dto.AcademicDisciplineDto;
import me.anisimov.teachingAccounting.repository.AcademicDisciplineRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicDisciplineService {
    @Autowired
    private AcademicDisciplineRepository academicDisciplineRepository;
    @Autowired
    private DozerBeanMapper mapper;

    public AcademicDisciplineDto createAcademicDiscipline(AcademicDisciplineDto academicDisciplineDto) {
        AcademicDiscipline academicDiscipline = new AcademicDiscipline();
        academicDiscipline.setId(academicDisciplineDto.getId());
        academicDiscipline.setDisciplineNumber(academicDiscipline.getDisciplineNumber());
        academicDiscipline.setName(academicDisciplineDto.getName());
        academicDisciplineRepository.save(academicDiscipline);
        return mapper.map(academicDiscipline, AcademicDisciplineDto.class);
    }

    public void deleteAcademicDiscipline(Long id) {
        academicDisciplineRepository.deleteById(id);
    }

    public void updateAcademicDiscipline(AcademicDiscipline academicDiscipline) {
        academicDisciplineRepository.save(academicDiscipline);
    }

    public AcademicDiscipline getById(Long id) {
        return academicDisciplineRepository.getReferenceById(id);
    }

    public List<AcademicDiscipline> getAll(){
        return academicDisciplineRepository.findAll();
    }

}
