package me.anisimov.teachingAccounting.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="academic_work")
@SequenceGenerator(name = "academic_work_seq_gen", sequenceName = "academic_work_seq", allocationSize = 1)
public class AcademicWork {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="academic_work_seq")
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "incomplete_reason")
    private String incompleteReason;

    @Column(name = "absolute_results")
    private Float absoluteResults;

    @Column(name = "quality_results")
    private Float qualityResults;

    @Column(name = "first_semester")
    private PlanAndFact firstSemester;

    @Column(name = "second_semester")
    private PlanAndFact secondSemester;

    @Column(name = "academic_year")
    private PlanAndFact academicYear;

    @ManyToOne(targetEntity = Specialization.class)
    @JoinColumn(name="specialization_id", nullable=false)
    private Specialization specialization;

    @ManyToOne(targetEntity = AcademicDiscipline.class)
    @JoinColumn(name="academic_discipline_id", nullable=false)
    private AcademicDiscipline academicDiscipline;

}
