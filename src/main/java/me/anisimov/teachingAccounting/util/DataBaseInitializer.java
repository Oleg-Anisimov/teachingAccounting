package me.anisimov.teachingAccounting.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Role;
import me.anisimov.teachingAccounting.dto.*;
import me.anisimov.teachingAccounting.repository.RoleRepository;
import me.anisimov.teachingAccounting.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;

@Component
@Slf4j

public class DataBaseInitializer {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    Map<String, JpaRepository> reposList;

    public void init() throws IOException, SQLException, InvocationTargetException, NoSuchMethodException, IllegalFormatException {

        log.info("*********");

        for (Map.Entry<String, JpaRepository> entry : reposList.entrySet())
            entry.getValue().deleteAll();

        List<EventDto> eventsDto = getEvents();
        for (EventDto eventDto : eventsDto) {
            ((EventService) applicationContext.getBean("eventService")).create(eventDto);
        }

        List<CabinetDto> cabinetsDto = getCabinets();
        for (CabinetDto cabinetDto : cabinetsDto) {
            ((CabinetService) applicationContext.getBean("cabinetService")).createCabinet(cabinetDto);
        }

        List<GroupDto> groupsDto = getGroups();
        for (GroupDto groupDto : groupsDto) {
            ((GroupService) applicationContext.getBean("groupService")).createGroup(groupDto);
        }

        List<Role> roles = getRoles();
        for (Role role : roles) {
            ((RoleRepository) applicationContext.getBean("roleRepository")).save(role);
        }

        List<UserDto> usersDto = getUsers();
        for (UserDto userDto : usersDto) {
            ((UserDetailsServiceImpl) applicationContext.getBean("userDetailsServiceImpl")).createUser(userDto);
        }
        List<DepartmentDto> departmentsDto = getDepartments();
        for (DepartmentDto departmentDto : departmentsDto) {
            ((DepartmentService) applicationContext.getBean("departmentService")).createDepartment(departmentDto);
        }

        List<TeacherDto> teachersDto = getTeachers();
        for (TeacherDto teacherDto : teachersDto) {
            ((TeacherService) applicationContext.getBean("teacherService")).createTeacher(teacherDto);
        }

        List<SpecializationDto> specializationsDto = getSpecializations();
        for (SpecializationDto specializationDto : specializationsDto) {
            ((SpecializationService) applicationContext.getBean("specializationService")).createSpecialization(specializationDto);
        }

        List<ScientificMethodsDto> scientificsMethodsDto = getScientificMethods();
        for (ScientificMethodsDto scientificMethodsDto : scientificsMethodsDto) {
            ((ScientificMethodsService) applicationContext.getBean("scientificMethodsService")).createScientificMethods(scientificMethodsDto);
        }

        List<PromotionQualificationLevelDto> promotionsQualificationLevelsDto = getPromotionQualificationLevels();
        for (PromotionQualificationLevelDto promotionQualificationLevelDto : promotionsQualificationLevelsDto) {
            ((PromotionQualificationLevelService) applicationContext.getBean("promotionQualificationLevelService")).createPromotionQualificationLevel(promotionQualificationLevelDto);
        }

        List<OrganizedMethodsDto> organizedMethodsDtos = getOrganizedMethods();
        for (OrganizedMethodsDto organizedMethodsDto : organizedMethodsDtos) {
            ((OrganizedMethodsService) applicationContext.getBean("organizedMethodsService")).createOrganizedMethods(organizedMethodsDto);
        }

        List<EducateDto> educatesDto = getEducates();
        for (EducateDto educateDto : educatesDto) {
            ((EducateService) applicationContext.getBean("educateService")).createEducate(educateDto);
        }

        List<AcademicDisciplineDto> academicsDisciplinesDto = getAcademicDisciplines();
        for (AcademicDisciplineDto academicDisciplineDto : academicsDisciplinesDto) {
            ((AcademicDisciplineService) applicationContext.getBean("academicDisciplineService")).createAcademicDiscipline(academicDisciplineDto);
        }

        List<AcademicWorkDto> academicsWorksDto = getAcademicWorks();
        for (AcademicWorkDto academicWorkDto : academicsWorksDto) {
            ((AcademicWorkService) applicationContext.getBean("academicWorkService")).createAcademicWork(academicWorkDto);
        }

        List<AcademicProductionDto> academicsProductionsDto = getAcademicProductions();
        for (AcademicProductionDto academicProductionDto : academicsProductionsDto) {
            ((AcademicProductionService) applicationContext.getBean("academicProductionService")).createAcademicProduction(academicProductionDto);
        }

        List<AcademicMethodsDto> academicsMethodsDto = getAcademicMethods();
        for (AcademicMethodsDto academicMethodsDto : academicsMethodsDto) {
            ((AcademicMethodsService) applicationContext.getBean("academicMethodsService")).createAcademicMethods(academicMethodsDto);
        }

    }

    private List<EventDto> getEvents() throws IOException {

        String json = readJsonFromFile("Event.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<EventDto> events = objectMapper.readValue(json, new TypeReference<List<EventDto>>() {
        });

        return events;

    }

    private List<CabinetDto> getCabinets() throws IOException {

        String json = readJsonFromFile("Cabinet.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<CabinetDto> cabinets = objectMapper.readValue(json, new TypeReference<List<CabinetDto>>() {
        });

        return cabinets;

    }

    private List<GroupDto> getGroups() throws IOException {

        String json = readJsonFromFile("Group.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<GroupDto> groups = objectMapper.readValue(json, new TypeReference<List<GroupDto>>() {
        });

        return groups;

    }

    private List<Role> getRoles() throws IOException {

        String json = readJsonFromFile("Role.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<Role> roles = objectMapper.readValue(json, new TypeReference<List<Role>>() {
        });

        return roles;

    }
    private List<UserDto> getUsers() throws IOException {

        String json = readJsonFromFile("User.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<UserDto> users = objectMapper.readValue(json, new TypeReference<List<UserDto>>() {
        });

        return users;

    }

    private List<TeacherDto> getTeachers() throws IOException {

        String json = readJsonFromFile("Teacher.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<TeacherDto> teachers = objectMapper.readValue(json, new TypeReference<List<TeacherDto>>() {
        });

        return teachers;

    }

    private List<SpecializationDto> getSpecializations() throws IOException {

        String json = readJsonFromFile("Specialization.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<SpecializationDto> specializations = objectMapper.readValue(json, new TypeReference<List<SpecializationDto>>() {
        });

        return specializations;

    }

    private List<ScientificMethodsDto> getScientificMethods() throws IOException {

        String json = readJsonFromFile("ScientificMethods.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<ScientificMethodsDto> scientificMethods = objectMapper.readValue(json, new TypeReference<List<ScientificMethodsDto>>() {
        });

        return scientificMethods;

    }

    private List<PromotionQualificationLevelDto> getPromotionQualificationLevels() throws IOException {

        String json = readJsonFromFile("PromotionQualificationLevel.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<PromotionQualificationLevelDto> promotionQualificationLevels = objectMapper.readValue(json, new TypeReference<List<PromotionQualificationLevelDto>>() {
        });

        return promotionQualificationLevels;

    }

    private List<OrganizedMethodsDto> getOrganizedMethods() throws IOException {

        String json = readJsonFromFile("OrganizedMethods.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<OrganizedMethodsDto> organizedMethods = objectMapper.readValue(json, new TypeReference<List<OrganizedMethodsDto>>() {
        });

        return organizedMethods;

    }

    private List<EducateDto> getEducates() throws IOException {

        String json = readJsonFromFile("Educate.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<EducateDto> educates = objectMapper.readValue(json, new TypeReference<List<EducateDto>>() {
        });

        return educates;

    }

    private List<DepartmentDto> getDepartments() throws IOException {

        String json = readJsonFromFile("Department.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<DepartmentDto> departments = objectMapper.readValue(json, new TypeReference<List<DepartmentDto>>() {
        });

        return departments;

    }

    private List<AcademicWorkDto> getAcademicWorks() throws IOException {

        String json = readJsonFromFile("AcademicWork.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicWorkDto> academicWorks = objectMapper.readValue(json, new TypeReference<List<AcademicWorkDto>>() {
        });

        return academicWorks;

    }

    private List<AcademicProductionDto> getAcademicProductions() throws IOException {

        String json = readJsonFromFile("AcademicProduction.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicProductionDto> academicProductions = objectMapper.readValue(json, new TypeReference<List<AcademicProductionDto>>() {
        });

        return academicProductions;

    }

    private List<AcademicMethodsDto> getAcademicMethods() throws IOException {

        String json = readJsonFromFile("AcademicMethods.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicMethodsDto> academicMethods = objectMapper.readValue(json, new TypeReference<List<AcademicMethodsDto>>() {
        });

        return academicMethods;

    }

    private List<AcademicDisciplineDto> getAcademicDisciplines() throws IOException {

        String json = readJsonFromFile("AcademicDiscipline.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicDisciplineDto> academicDisciplines = objectMapper.readValue(json, new TypeReference<List<AcademicDisciplineDto>>() {
        });

        return academicDisciplines;

    }

    private String readJsonFromFile(String file) throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(file);
        String json = new String(resourceAsStream.readAllBytes(), StandardCharsets.UTF_8);
        return json;
    }

}
