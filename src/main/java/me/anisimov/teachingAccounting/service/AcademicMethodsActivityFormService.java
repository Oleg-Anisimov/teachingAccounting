package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicMethodsActivityForm;
import me.anisimov.teachingAccounting.dto.AcademicMethodsActivityFormDto;
import me.anisimov.teachingAccounting.repository.AcademicMethodsActivityFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class AcademicMethodsActivityFormService {

    @Autowired
    private AcademicMethodsActivityFormRepository academicMethodsActivityFormRepository;
    @Autowired
    private ModelMapper mapper;

    public AcademicMethodsActivityFormDto createAcademicMethodsActivityForm(AcademicMethodsActivityFormDto academicMethodsActivityFormDto){
        AcademicMethodsActivityForm academicMethodsActivityForm = new AcademicMethodsActivityForm();
        academicMethodsActivityForm.setId(academicMethodsActivityFormDto.getId());
        academicMethodsActivityForm.setName(academicMethodsActivityFormDto.getName());
        academicMethodsActivityFormRepository.save(academicMethodsActivityForm);
        return mapper.map(academicMethodsActivityForm, AcademicMethodsActivityFormDto.class);
    }

    public void deleteAcademicMethodsActivityForm(Long id) {
        academicMethodsActivityFormRepository.deleteById(id);
    }

    public void updateAcademicMethodsActivityForm(AcademicMethodsActivityForm academicMethodsActivityForm) {
        academicMethodsActivityFormRepository.save(academicMethodsActivityForm);
    }

    public AcademicMethodsActivityForm getById(Long id) {
        return academicMethodsActivityFormRepository.getReferenceById(id);
    }

    public List<AcademicMethodsActivityForm> getAll() {
        return academicMethodsActivityFormRepository.findAll();
    }
}
