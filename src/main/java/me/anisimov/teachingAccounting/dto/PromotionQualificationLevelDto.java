package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionQualificationLevelDto {

    private Long id;
    private LocalDate date;
    private String topic;
    private String documentOrResult;
    private Long promotionFormId;
}
