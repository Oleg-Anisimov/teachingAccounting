package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.ScientificMethods;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.dto.ScientificMethodsDto;
import me.anisimov.teachingAccounting.service.ScientificMethodsService;
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
@RequestMapping("/scientific")
@Api(value = "TeacherController",tags = {"Методы для работы с научно-методическими работами"})
public class ScientificMethodsController {

    @Autowired
    private ScientificMethodsService scientificMethodsService;

    @PostMapping("/create")
    public ScientificMethodsDto create(@RequestBody ScientificMethodsDto scientificMethods) {
        return scientificMethodsService.createScientificMethods(scientificMethods);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        scientificMethodsService.deleteScientificMethods(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody ScientificMethods scientificMethods) {
        scientificMethodsService.updateScientificMethods(scientificMethods);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public ScientificMethods getById(Long id) {
        return scientificMethodsService.getById(id);
    }

    @GetMapping("/all")
    public List<ScientificMethodsDto> getAll() {
        return scientificMethodsService.getAll();
    }

    @PostMapping()
    public Page<ScientificMethodsDto> getCurrent(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return scientificMethodsService.getCurrentScientificMethods(pageRequest);
    }

    @GetMapping("/excel")
    public ResponseEntity exportToExcel() throws IOException {

        FileSystemResource fileSystemResource = scientificMethodsService.exportToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        headers.setContentLength(fileSystemResource.contentLength());
        headers.setContentDispositionFormData("attachment", fileSystemResource.getFilename());

        return new ResponseEntity(fileSystemResource, headers, HttpStatus.OK);
    }
}
