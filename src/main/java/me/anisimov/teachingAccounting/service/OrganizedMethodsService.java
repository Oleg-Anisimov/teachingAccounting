package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.OrganizedMethods;
import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.dto.OrganizedMethodsDto;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.repository.OrganizedMethodsRepository;
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
public class OrganizedMethodsService {

    @Autowired
    private OrganizedMethodsRepository organizedMethodsRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ExportToExcelService exportToExcelService;
    @Autowired
    private EntityRepository entityRepository;


    public OrganizedMethodsDto createOrganizedMethods(OrganizedMethodsDto organizedMethodsDto) {

        Long userId = organizedMethodsDto.getUserId();
        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        OrganizedMethods organizedMethods = new OrganizedMethods();
        organizedMethods.setUser(user);
        organizedMethods.setDate(organizedMethodsDto.getDate());
        organizedMethods.setResult(organizedMethodsDto.getResult());
        organizedMethods.setEventName(organizedMethodsDto.getEventName());
        organizedMethods.setEventLevel(organizedMethodsDto.getEventLevel());
        organizedMethods.setEventType(organizedMethodsDto.getEventType());
        organizedMethods.setStudentInformation(organizedMethodsDto.getStudentInformation());
        organizedMethods.setActivityType(organizedMethodsDto.getActivityType());
        organizedMethods = organizedMethodsRepository.save(organizedMethods);
        return mapper.map(organizedMethods, OrganizedMethodsDto.class);
    }

    public void deleteOrganizedMethods(Long id) {
        organizedMethodsRepository.deleteById(id);
    }

    public void updateOrganizedMethods(OrganizedMethods organizedMethods) {
        organizedMethodsRepository.save(organizedMethods);
    }

    public OrganizedMethods getById(Long id) {
        return organizedMethodsRepository.getReferenceById(id);
    }

    public List<OrganizedMethodsDto> getAll() {
        return organizedMethodsRepository.findAll().stream()
                .map(entity -> mapper.map(entity, OrganizedMethodsDto.class))
                .collect(Collectors.toList());
    }

    public Page<OrganizedMethodsDto> getCurrentOrganizedMethods(PageRequest pageRequest) {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        Page<OrganizedMethodsDto> allUserInformation = organizedMethodsRepository.getAllByUser(user, pageRequest)
                .map(method -> {
                    return mapper.map(method, OrganizedMethodsDto.class);
                });
        return allUserInformation;
    }

    public FileSystemResource exportToExcel() {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        List<OrganizedMethods> organizedMethods = entityRepository.listForUser(OrganizedMethods.class, user);

        String[] fieldNames = {
                "id", "activityType", "eventType",
                "eventName", "eventLevel", "date",
                "studentInformation", "result"
        };
        String filename = "OrganizedMethods_" + LocalDate.now() + ".xlsx";
        exportToExcelService.export(filename, fieldNames, organizedMethods);
        return new FileSystemResource(new File(filename));
    }
}
