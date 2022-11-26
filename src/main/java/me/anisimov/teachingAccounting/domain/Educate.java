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

    @ManyToOne(targetEntity = EducateActivityType.class)
    @JoinColumn(name="activityType_id", nullable=false)
    private EducateActivityType activityType;

    @ManyToOne(targetEntity = WorkVector.class)
    @JoinColumn(name="work_vector_id", nullable=false)
    private WorkVector workVector;


}
