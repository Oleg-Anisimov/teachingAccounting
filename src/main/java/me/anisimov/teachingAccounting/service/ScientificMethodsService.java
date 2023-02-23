package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.ScientificMethods;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.dto.ScientificMethodsDto;
import me.anisimov.teachingAccounting.repository.EntityRepository;
import me.anisimov.teachingAccounting.repository.ScientificMethodsRepository;
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
public class ScientificMethodsService {

    @Autowired
    private ScientificMethodsRepository scientificMethodsRepository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private ExportToExcelService exportToExcelService;
    @Autowired
    private EntityRepository entityRepository;

    public ScientificMethodsDto createScientificMethods(ScientificMethodsDto scientificMethodsDto) {

        Long userId = scientificMethodsDto.getUserId();
        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        ScientificMethods scientificMethods = new ScientificMethods();
        scientificMethods.setUser(user);
        scientificMethods.setDate(scientificMethodsDto.getDate());
        scientificMethods.setPlace(scientificMethodsDto.getPlace());
        scientificMethods.setEventName(scientificMethodsDto.getEventName());
        scientificMethods.setEventType(scientificMethodsDto.getEventType());
        scientificMethods.setResult(scientificMethodsDto.getResult());
        scientificMethods.setActivityType(scientificMethodsDto.getActivityType());
        scientificMethods.setEventLevel(scientificMethodsDto.getEventLevel());
        scientificMethods.setParticipationType(scientificMethodsDto.getParticipationType());
        scientificMethods.setStudentInformation(scientificMethodsDto.getStudentInformation());

        scientificMethods = scientificMethodsRepository.save(scientificMethods);
        return mapper.map(scientificMethods, ScientificMethodsDto.class);
    }

    public void deleteScientificMethods(Long id) {
        scientificMethodsRepository.deleteById(id);
    }

    public void updateScientificMethods(ScientificMethods scientificMethods) {
        scientificMethodsRepository.save(scientificMethods);
    }

    public ScientificMethods getById(Long id) {
        return scientificMethodsRepository.getReferenceById(id);
    }

    public List<ScientificMethodsDto> getAll() {
        return scientificMethodsRepository.findAll().stream().map(entity -> mapper.map(entity, ScientificMethodsDto.class)).collect(Collectors.toList());
    }

    public Page<ScientificMethodsDto> getCurrentScientificMethods(PageRequest pageRequest) {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        Page<ScientificMethodsDto> allUsersInformation = scientificMethodsRepository.getAllByUser(user, pageRequest).map(work -> {
            return mapper.map(work, ScientificMethodsDto.class);
        });
        return allUsersInformation;
    }

    public FileSystemResource exportToExcel() {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        List<ScientificMethods> scientificMethods = entityRepository.listForUser(ScientificMethods.class, user);

        String[] fieldNames = {
                "id", "activityType", "eventType",
                "eventName", "eventLevel", "date",
                "place", "participationType", "result"
        };
        String filename = "ScientificMethods_" + LocalDate.now() + ".xlsx";
        exportToExcelService.export(filename, fieldNames, scientificMethods);
        return new FileSystemResource(new File(filename));

    }
}
