package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scientific_activity_type")
@SequenceGenerator(name = "scientific_activity_type_seq_gen", sequenceName = "scientific_activity_type_seq", allocationSize = 1)
public class ScientificActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scientific_activity_type_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
