package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.service.AcademicMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/methods")
@Api(value = "TeacherController",tags = {"Методы для работы с учебно-методической работой"})
public class AcademicMethodsController {
    @Autowired
    private AcademicMethodsService academicMethodsService;

    @PostMapping("/create")
    public AcademicMethodsDto create(@RequestBody AcademicMethodsDto academicMethodsDto) {
        return academicMethodsService.createAcademicMethods(academicMethodsDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicMethodsService.deleteAcademicMethods(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicMethods academicMethods) {
        academicMethodsService.updateAcademicMethods(academicMethods);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicMethods getById(Long id) {
        return academicMethodsService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicMethodsDto> getAll() {
        return academicMethodsService.getAll();
    }

    @PostMapping()
    public Page<AcademicMethodsDto> getCurrent(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return academicMethodsService.getCurrentAcademicMethods(pageRequest);
    }

    @GetMapping("/excel")
    public ResponseEntity exportToExcel() throws IOException {
        FileSystemResource fileSystemResource = academicMethodsService.exportToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        headers.setContentLength(fileSystemResource.contentLength());
        headers.setContentDispositionFormData("attachment", fileSystemResource.getFilename());

        return new ResponseEntity(fileSystemResource, headers, HttpStatus.OK);
    }
}
