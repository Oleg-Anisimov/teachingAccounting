package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="academic_discipline")
@SequenceGenerator(name = "academic_discipline_seq_gen", sequenceName = "academic_discipline_seq", allocationSize = 1)
public class AcademicDiscipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_discipline_seq")
    private Long id;

    @Column(name = "discipline_number")
    private String disciplineNumber;

    @Column(name = "name")
    private String name;
}
