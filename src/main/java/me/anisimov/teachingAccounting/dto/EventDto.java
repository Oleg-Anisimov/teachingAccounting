package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private Long id;
    private String eventName;
    private String eventType;
    private String eventLevel;
}
