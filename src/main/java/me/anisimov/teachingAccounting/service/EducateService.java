package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicProduction;
import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.EducateDto;
import me.anisimov.teachingAccounting.repository.EducateRepository;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
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
    @Autowired
    private ExportToExcelService exportToExcelService;
    @Autowired
    private EventService eventService;
    @Autowired
    private EntityRepository entityRepository;

    public EducateDto createEducate(EducateDto educateDto) {

        Long userId = educateDto.getUserId();
        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        Educate educate = new Educate();
        educate.setUser(user);
        educate.setDate(educateDto.getDate());
        educate.setResult(educateDto.getResult());
        educate.setEvent(eventService.getById(educateDto.getEventId()));
        educate.setActivityType(educateDto.getActivityType());
        educate.setStudentInformation(educateDto.getStudentInformation());
        educate.setWorkVector(educateDto.getWorkVector());
        educate = educateRepository.save(educate);
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

    public FileSystemResource exportToExcel() {

        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        List<Educate> educates = entityRepository.listForUser(Educate.class, user);

        String[] fieldNames = {
                "id", "workVector", "activityType",
                "eventType", "eventName", "eventLevel",
                "date", "studentInformation", "result"
        };
        String filename = "Educate_" + LocalDate.now() + ".xlsx";

        exportToExcelService.export(filename, fieldNames, educates);

        return new FileSystemResource(new File(filename));

    }

}
