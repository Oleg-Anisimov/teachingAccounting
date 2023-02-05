package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.AcademicDiscipline;
import me.anisimov.teachingAccounting.domain.Enums.AcademicMethodActivityForm;
import me.anisimov.teachingAccounting.domain.Enums.AcademicMethodActivityType;
import me.anisimov.teachingAccounting.domain.Enums.ActivityType;
import me.anisimov.teachingAccounting.domain.Specialization;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicMethodsDto {
    private Long id;
    private LocalDate deadLine;
    private String completeInfo;
    private AcademicMethodActivityType academicMethodActivityType;
    private AcademicMethodActivityForm academicMethodActivityForm;
    private ActivityType activityType;
    private Long specializationId;
    private Long academicDisciplineId;
    private Long userId;
}
