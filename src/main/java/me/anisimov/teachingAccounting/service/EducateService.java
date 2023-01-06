package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.EducateDto;
import me.anisimov.teachingAccounting.repository.EducateRepository;
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
public class EducateService {

    @Autowired
    private EducateRepository educateRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public EducateDto createEducate(EducateDto educateDto) {

        Long userId = educateDto.getUserId();
        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        Educate educate = new Educate();
        educate.setUser(user);
        educate.setId(educateDto.getId());
        educate.setDate(educateDto.getDate());
        educate.setResult(educateDto.getResult());
        educate.setEventType(educateDto.getEventType());
        educate.setEventName(educateDto.getEventName());
        educate.setEventLevel(educateDto.getEventLevel());
        educate.setActivityType(educateDto.getActivityType());
        educate.setStudentInformation(educateDto.getStudentInformation());
        educate.setWorkVector(educateDto.getWorkVector());
        educateRepository.save(educate);
        return mapper.map(educate, EducateDto.class);
    }

    public void deleteEducate(Long id) {
        educateRepository.deleteById(id);
    }

    public void updateEducate(Educate educate) {
        educateRepository.save(educate);
    }

    public Educate getById(Long id) {
        return educateRepository.getReferenceById(id);
    }

    public List<EducateDto> getAll() {
        return educateRepository.findAll().stream()
                .map(entity -> mapper.map(entity,EducateDto.class))
                .collect(Collectors.toList());
    }

    public Page<EducateDto> getCurrentEducate(PageRequest pageRequest){
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        Page<EducateDto> allUserInformation = educateRepository.getAllByUser(user, pageRequest).map(educate ->{
            return mapper.map(educate,EducateDto.class);
                });
        return allUserInformation;
    }
}
