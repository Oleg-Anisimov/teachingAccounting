package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="event")
@SequenceGenerator(name = "event_seq_gen", sequenceName = "event_seq", allocationSize = 1)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    private Long id;

    @Column(name="event_name")
    private String eventName;

    @Column(name="event_type")
    private String eventType;

    @Column(name="event_level")
    private String eventLevel;

}
