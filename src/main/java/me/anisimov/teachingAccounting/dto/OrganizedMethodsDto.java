package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.ActivityType;
import me.anisimov.teachingAccounting.domain.Enums.EventLevel;
import me.anisimov.teachingAccounting.domain.Enums.EventType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizedMethodsDto {

    private Long id;
    private LocalDate date;
    private String result;
    private String studentInformation;
    private ActivityType activityType;
    private Long eventId;
    private Long userId;
}
