package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.AcademicProductionActivityForm;
import me.anisimov.teachingAccounting.domain.Enums.ActivityType;
import me.anisimov.teachingAccounting.domain.Enums.CabinetType;
import me.anisimov.teachingAccounting.domain.Specialization;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicProductionDto {
    private Long id;
    private LocalDate date;
    private String result;
    private AcademicProductionActivityForm academicProductionActivityForm;
    private CabinetType cabinetType;
    private String cabinetName;
    private ActivityType activityType;
    private Specialization specialization;

}
