package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicProductionDto {
    private Long id;
    private LocalDate date;
    private String result;
    private Long academicProductionActivityFormId;
    private Long cabinetId;
    private Long academicWorkActivityTypeId;
    private Long specializationId;

}
