package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.Department;
import me.anisimov.teachingAccounting.dto.TeacherDto;
import me.anisimov.teachingAccounting.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping ("/create")
    public TeacherDto create() {
        TeacherDto teacherDto = new TeacherDto();
        Department department = new Department();
        department.setId(1L);
        teacherDto.setFirstName("Oleg");
        teacherDto.setDepartment(department);
        return teacherService.createTeacher(teacherDto);
    }
    @GetMapping("/delete")
    public ResponseEntity delete() {
        teacherService.deleteTeacher(202L);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/update")
    public ResponseEntity update() {
        teacherService.updateTeacher(teacherService.getById(153L));
        return ResponseEntity.ok().build();
    }

}
