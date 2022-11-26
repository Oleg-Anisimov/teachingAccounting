package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="organized_methods")
@SequenceGenerator(name = "organized_methods_seq_gen", sequenceName = "organized_methods_seq", allocationSize = 1)
public class OrganizedMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organized_methods_seq")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "result")
    private String result;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "student_information")
    private String studentInformation;

    @ManyToOne(targetEntity = EventType.class)
    @JoinColumn(name="event_type_id", nullable=false)
    private EventType eventType;

    @ManyToOne(targetEntity = EventLevel.class)
    @JoinColumn(name="event_level_id", nullable=false)
    private EventLevel eventLevel;

    @ManyToOne(targetEntity = OrganizedActivityType.class)
    @JoinColumn(name="activityType_id", nullable=false)
    private OrganizedActivityType activityType;

}
