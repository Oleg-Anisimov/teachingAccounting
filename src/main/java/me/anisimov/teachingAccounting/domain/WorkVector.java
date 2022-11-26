package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_vector")
@SequenceGenerator(name = "work_vector_seq_gen", sequenceName = "work_vector_seq", allocationSize = 1)
public class WorkVector {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_vector_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
