package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.AcademicProduction;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.dto.EducateDto;
import me.anisimov.teachingAccounting.service.AcademicProductionService;
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
@RequestMapping("/production")
@Api(value = "TeacherController",tags = {"Методы для работы с учебно-производственной работой"})
public class AcademicProductionController {

    @Autowired
    private AcademicProductionService academicProductionService;

    @PostMapping("/create")
    public AcademicProductionDto create(@RequestBody AcademicProductionDto academicProductionDto) {
        return academicProductionService.createAcademicProduction(academicProductionDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicProductionService.deleteAcademicProduction(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicProduction academicProduction) {
        academicProductionService.updateAcademicProduction(academicProduction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicProduction getById(Long id) {
        return academicProductionService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicProductionDto> getAll() {
        return academicProductionService.getAll();
    }

    @PostMapping()
    public Page<AcademicProductionDto> getCurrent(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return academicProductionService.getCurrentAcademicProduction(pageRequest);
    }

    @GetMapping("/excel")
    public ResponseEntity exportToExcel() throws IOException {

        FileSystemResource fileSystemResource = academicProductionService.exportToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        headers.setContentLength(fileSystemResource.contentLength());
        headers.setContentDispositionFormData("attachment", fileSystemResource.getFilename());

        return new ResponseEntity(fileSystemResource, headers, HttpStatus.OK);
    }
}
