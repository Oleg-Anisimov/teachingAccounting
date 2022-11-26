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
@Table(name ="scientific_methods")
@SequenceGenerator(name = "scientific_methods_seq_gen", sequenceName = "scientific_methods_seq", allocationSize = 1)
public class ScientificMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scientific_methods_seq")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "place")
    private String place;

    @Column(name = "result")
    private String result;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "student_information")
    private String studentInformation;

    @ManyToOne(targetEntity = EventLevel.class)
    @JoinColumn(name="event_level_id", nullable=false)
    private EventLevel eventLevel;

    @ManyToOne(targetEntity = EventType.class)
    @JoinColumn(name="event_type_id", nullable=false)
    private EventType eventType;

    @ManyToOne(targetEntity = ScientificActivityType.class)
    @JoinColumn(name="activityType_id", nullable=false)
    private ScientificActivityType scientificActivityType;

    @ManyToOne(targetEntity = ParticipationType.class)
    @JoinColumn(name="participationType_id", nullable=false)
    private ParticipationType participationType;

}
