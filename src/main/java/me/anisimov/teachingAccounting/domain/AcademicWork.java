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

    @Column(name = "incomplete_reason")
    private String incompleteReason;

    @Column(name = "absolute_results")
    private Float absoluteResults;

    @Column(name = "quality_results")
    private Float qualityResults;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "plan",column = @Column(name = "first_semestr_plan")),
            @AttributeOverride(name = "fact",column = @Column(name = "first_semestr_fact"))
    })
    private PlanAndFact firstSemester;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "plan",column = @Column(name = "second_semestr_plan")),
            @AttributeOverride(name = "fact",column = @Column(name = "second_semestr_fact"))
    })
    private PlanAndFact secondSemester;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "plan",column = @Column(name = "academic_year_semestr_plan")),
            @AttributeOverride(name = "fact",column = @Column(name = "academic_year_semestr_fact"))
    })
    private PlanAndFact academicYear;

    @ManyToOne(targetEntity = Specialization.class)
    @JoinColumn(name="specialization_id", nullable=false)
    private Specialization specialization;

    @ManyToOne(targetEntity = AcademicDiscipline.class)
    @JoinColumn(name="academic_discipline_id", nullable=false)
    private AcademicDiscipline academicDiscipline;

    @ManyToOne(targetEntity = Group.class )
    @JoinColumn(name = "group_id", nullable=false)
    private Group group;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
