package com.example.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="department")
@SequenceGenerator(name = "department_seq_gen", sequenceName = "department_seq", allocationSize = 1)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_seq")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;
}
