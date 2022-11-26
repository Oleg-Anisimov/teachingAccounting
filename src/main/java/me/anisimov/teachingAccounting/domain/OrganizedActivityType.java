package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organized_activity_type")
@SequenceGenerator(name = "organized_activity_type_seq_gen", sequenceName = "organized_activity_type_seq", allocationSize = 1)
public class OrganizedActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organized_activity_type_seq")
    private Long id;

    @Column(name = "name")
    private String name;

}
