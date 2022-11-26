package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicMethodsDto {
    private Long id;
    private LocalDate deadLine;
    private String completeInfo;
    private Long academicMethodActivityTypeId;
    private Long academicMethodActivityFormId;
    private Long academicWorkActivityTypeId;
    private Long specializationId;
    private Long academicDisciplineId;
}
