package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.ActivityType;
import me.anisimov.teachingAccounting.domain.Enums.EventLevel;
import me.anisimov.teachingAccounting.domain.Enums.WorkVector;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="educate")
@SequenceGenerator(name = "educate_seq_gen", sequenceName = "educate_seq", allocationSize = 1)
public class Educate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "educate_seq")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "result")
    private String result;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "student_information")
    private String studentInformation;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_level")
    private EventLevel eventLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type")
    private ActivityType activityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "work_vector")
    private WorkVector workVector;


}
