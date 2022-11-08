package com.example.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="specialization")
@SequenceGenerator(name = "specialization_seq_gen", sequenceName = "specialization_seq", allocationSize = 1)
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialization_seq")
    private Long id;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "specialization_name")
    private String specializationName;
}
