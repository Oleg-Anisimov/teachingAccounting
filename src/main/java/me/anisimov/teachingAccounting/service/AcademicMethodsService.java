package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.repository.AcademicMethodsRepository;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AcademicMethodsService {

    @Autowired
    private AcademicMethodsRepository academicMethodsRepository;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private AcademicDisciplineService academicDisciplineService;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public AcademicMethodsDto createAcademicMethods(AcademicMethodsDto academicMethodsDto) {
        AcademicMethods academicMethods = new AcademicMethods();
        academicMethods.setId(academicMethodsDto.getId());
        academicMethods.setAcademicDiscipline(academicDisciplineService.getById(academicMethodsDto.getAcademicDisciplineId()));
        academicMethods.setAcademicMethodActivityForm(academicMethodsDto.getAcademicMethodActivityForm());
        academicMethods.setAcademicMethodActivityType(academicMethodsDto.getAcademicMethodActivityType());
        academicMethods.setSpecialization(specializationService.getById(academicMethodsDto.getSpecializationId()));
        academicMethods.setActivityType(academicMethodsDto.getActivityType());
        academicMethods.setDeadLine(academicMethodsDto.getDeadLine());
        academicMethods.setCompleteInfo(academicMethodsDto.getCompleteInfo());
        academicMethods.setUser(userDetailsServiceImpl.getById(academicMethodsDto.getUserId()));
        academicMethodsRepository.save(academicMethods);
        return mapper.map(academicMethods, AcademicMethodsDto.class);
    }

    public void deleteAcademicMethods(Long id) {
        academicMethodsRepository.deleteById(id);
    }

    public void updateAcademicMethods(AcademicMethods academicMethods) {
        academicMethodsRepository.save(academicMethods);
    }

    public AcademicMethods getById(Long id) {
        return academicMethodsRepository.getReferenceById(id);
    }

    public List<AcademicMethods> getAll(){
        return academicMethodsRepository.findAll();
    }

    public List<AcademicMethodsDto> getCurrentAcademicMethods() {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        List<AcademicMethodsDto> allUsersInformation = academicMethodsRepository.findAllByUser(user.getId()).stream().map(work -> {
            return mapper.map(work, AcademicMethodsDto.class);
        }).collect(Collectors.toList());
        return allUsersInformation;
    }
}

