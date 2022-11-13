package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.Category;
import me.anisimov.teachingAccounting.domain.Department;
import me.anisimov.teachingAccounting.domain.Enums.EmploymentType;
import me.anisimov.teachingAccounting.domain.Enums.Position;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate certificationDate;
    private EmploymentType employmentType;
    private Position position;
    private Category category;
    private Long departmentId;
}
