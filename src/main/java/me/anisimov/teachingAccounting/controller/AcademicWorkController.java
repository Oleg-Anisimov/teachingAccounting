package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.dto.AcademicWorkDto;
import me.anisimov.teachingAccounting.service.AcademicWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/work")
@Api(value = "TeacherController",tags = {"Методы для работы с учебной работой"})
public class AcademicWorkController {

    @Autowired
    private AcademicWorkService academicWorkService;

    @PostMapping("/create")
    public AcademicWorkDto create(@RequestBody AcademicWorkDto academicWorkDto) {
        return academicWorkService.createAcademicWork(academicWorkDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicWorkService.deleteAcademicWork(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicWork academicWork) {
        academicWorkService.updateAcademicWork(academicWork);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicWork getById(Long id) {
        return academicWorkService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicWorkDto> getAll() {
        return academicWorkService.getAll();
    }

    @PostMapping()
    public Page<AcademicWorkDto> getCurrent(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return academicWorkService.getCurrentAcademicWork(pageRequest);
    }

    @GetMapping("/excel")
    public ResponseEntity exportToExcel() throws IOException {

        FileSystemResource fileSystemResource = academicWorkService.exportToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        headers.setContentLength(fileSystemResource.contentLength());
        headers.setContentDispositionFormData("attachment", fileSystemResource.getFilename());

        return new ResponseEntity(fileSystemResource, headers, HttpStatus.OK);
    }
}
