package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employment_type")
@SequenceGenerator(name = "employment_type_seq_gen", sequenceName = "employment_type_seq", allocationSize = 1)
public class EmploymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employment_type_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
