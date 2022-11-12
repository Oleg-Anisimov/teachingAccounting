package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.dto.TeacherDto;
import me.anisimov.teachingAccounting.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public TeacherDto create(@RequestBody TeacherDto teacherDto) {
        return teacherService.createTeacher(teacherDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Teacher getById(Long id) {
        return teacherService.getById(id);
    }

    @GetMapping("/all")
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

}
