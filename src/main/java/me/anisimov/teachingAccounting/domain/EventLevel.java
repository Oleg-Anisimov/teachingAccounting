package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_level")
@SequenceGenerator(name = "event_level_seq_gen", sequenceName = "event_level_seq", allocationSize = 1)
public class EventLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_level_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
