package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicProduction;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.repository.AcademicProductionRepository;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AcademicProductionService {

    @Autowired
    private AcademicProductionRepository academicProductionRepository;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public AcademicProductionDto createAcademicProduction(AcademicProductionDto academicProductionDto) {

        Long userId = academicProductionDto.getUserId();
        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        AcademicProduction academicProduction = new AcademicProduction();
        academicProduction.setUser(user);
        academicProduction.setId(academicProductionDto.getId());
        academicProduction.setDate(academicProductionDto.getDate());
        academicProduction.setResult(academicProductionDto.getResult());
        academicProduction.setAcademicProductionActivityForm(academicProductionDto.getAcademicProductionActivityForm());
        academicProduction.setSpecialization(specializationService.getById(academicProductionDto.getSpecializationId()));
        academicProduction.setActivityType(academicProductionDto.getActivityType());
        academicProduction.setCabinetType(academicProductionDto.getCabinetType());
        academicProduction.setCabinetName(academicProductionDto.getCabinetName());
        academicProductionRepository.save(academicProduction);
        return mapper.map(academicProduction, AcademicProductionDto.class);
    }

    public void deleteAcademicProduction(Long id) {
        academicProductionRepository.deleteById(id);
    }

    public void updateAcademicProduction(AcademicProduction academicProduction) {
        academicProductionRepository.save(academicProduction);
    }

    public AcademicProduction getById(Long id) {
        return academicProductionRepository.getReferenceById(id);
    }

    public List<AcademicProductionDto> getAll(){
        return academicProductionRepository.findAll().stream()
                .map(entity -> mapper.map(entity,AcademicProductionDto.class))
                .collect(Collectors.toList());
    }
    public Page<AcademicProductionDto> getCurrentAcademicProduction(PageRequest pageRequest){
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        Page<AcademicProductionDto> allUserInformation = academicProductionRepository.getAllByUser(user, pageRequest).map(production ->{
                    return mapper.map(production,AcademicProductionDto.class);
        });
        return allUserInformation;
    }
}

