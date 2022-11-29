package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.AcademicDiscipline;
import me.anisimov.teachingAccounting.domain.PlanAndFact;
import me.anisimov.teachingAccounting.domain.Specialization;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicWorkDto {
    private Long id;
    private String incompleteReason;
    private Float absoluteResults;
    private Float qualityResults;
    private PlanAndFact firstSemester;
    private PlanAndFact secondSemester;
    private PlanAndFact academicYear;
    private Long specializationId;
    private Long academicDisciplineId;
    private Long groupId;
    private Long userId;
}
