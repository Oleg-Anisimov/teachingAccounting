package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.ActivityType;
import me.anisimov.teachingAccounting.domain.Enums.EventLevel;
import me.anisimov.teachingAccounting.domain.Enums.ParticipationType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScientificMethodsDto {

    private Long id;
    private LocalDate date;
    private String place;
    private String result;
    private String eventType;
    private String eventName;
    private String studentInformation;
    private EventLevel eventLevel;
    private ActivityType activityType;
    private ParticipationType participationType;
    private Long userId;
}
