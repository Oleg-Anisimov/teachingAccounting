package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long employmentTypeId;
    private Long positionId;
    private Long categoryId;
    private Long departmentId;
    private Long userId;
}
