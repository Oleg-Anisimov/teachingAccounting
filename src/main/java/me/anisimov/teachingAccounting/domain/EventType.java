package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_type")
@SequenceGenerator(name = "event_type_seq_gen", sequenceName = "event_type_seq", allocationSize = 1)
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_type_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
