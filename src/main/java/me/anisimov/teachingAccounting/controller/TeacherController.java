package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.dto.TeacherDto;
import me.anisimov.teachingAccounting.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(value = "TeacherController",tags = {"Методы для работы с преподователями"})
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

    @GetMapping("/current")
    public TeacherDto getCurrentTeacher(){
        return teacherService.getCurrentTeacher();
    }

}
