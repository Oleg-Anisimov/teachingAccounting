package util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.*;
import me.anisimov.teachingAccounting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.IllegalFormatException;
import java.util.List;

@Component
@Slf4j
@Profile("")
public class DataBaseInitializer {

    @Autowired
    List<JpaRepository> reposList;

    public void init() throws IOException, SQLException, InvocationTargetException, NoSuchMethodException, IllegalFormatException {

        for(JpaRepository repo: reposList) {

            repo.deleteAll();

        }

    }

    private List<Teacher> getTeachers() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("Teacher.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<Teacher> teachers = objectMapper.readValue(json, new TypeReference<List<Teacher>>() {
        });

        return teachers;

    }

    private List<Specialization> getSpecializations() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("Specialization.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<Specialization> specializations = objectMapper.readValue(json, new TypeReference<List<Specialization>>() {
        });

        return specializations;

    }

    private List<ScientificMethods> getScientificMethods() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("ScientificMethods.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<ScientificMethods> scientificMethods = objectMapper.readValue(json, new TypeReference<List<ScientificMethods>>() {
        });

        return scientificMethods;

    }

    private List<PromotionQualificationLevel> getPromotionQualificationLevels() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("PromotionQualificationLevel.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<PromotionQualificationLevel> promotionQualificationLevels = objectMapper.readValue(json, new TypeReference<List<PromotionQualificationLevel>>() {
        });

        return promotionQualificationLevels;

    }

    private List<OrganizedMethods> getOrganizedMethods() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("OrganizedMethods.json.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<OrganizedMethods> organizedMethods = objectMapper.readValue(json, new TypeReference<List<OrganizedMethods>>() {
        });

        return organizedMethods;

    }

    private List<Educate> getEducates() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("Educate.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<Educate> educates = objectMapper.readValue(json, new TypeReference<List<Educate>>() {
        });

        return educates;

    }

    private List<Department> getDepartments() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("Department.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<Department> departments = objectMapper.readValue(json, new TypeReference<List<Department>>() {
        });

        return departments;

    }

    private List<AcademicWork> getAcademicWorks() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("AcademicWork.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicWork> academicWorks = objectMapper.readValue(json, new TypeReference<List<AcademicWork>>() {
        });

        return academicWorks;

    }

    private List<AcademicProduction> getAcademicProductions() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("AcademicProduction.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicProduction> academicProductions = objectMapper.readValue(json, new TypeReference<List<AcademicProduction>>() {
        });

        return academicProductions;

    }

    private List<AcademicMethods> getAcademicMethods() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("AcademicMethods.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicMethods> academicMethods = objectMapper.readValue(json, new TypeReference<List<AcademicMethods>>() {
        });

        return academicMethods;

    }

    private List<AcademicDiscipline> getAcademicDisciplines() throws IOException {

        File resource = new File(this.getClass().getClassLoader().getResource("AcademicDiscipline.json.json").getFile());
        String json = new String(Files.readAllBytes(resource.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<AcademicDiscipline> academicDisciplines = objectMapper.readValue(json, new TypeReference<List<AcademicDiscipline>>() {
        });

        return academicDisciplines;

    }

}
