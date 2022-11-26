package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScientificMethodsDto {

    private Long id;
    private LocalDate date;
    private String place;
    private String result;
    private String eventName;
    private String studentInformation;
    private Long eventTypeId;
    private Long eventLevelId;
    private Long scientificActivityTypeId;
    private Long participationTypeId;
}
