package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "position")
@SequenceGenerator(name = "position_seq_gen", sequenceName = "position_seq", allocationSize = 1)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
