package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.ActivityType;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="academic_methods")
@SequenceGenerator(name = "academic_methods_seq_gen", sequenceName = "methods_work_seq", allocationSize = 1)
public class AcademicMethods extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "methods_work_seq")
    private Long id;

    @Column(name = "dead_line")
    private LocalDate deadLine;

    @Column(name = "complete_info")
    private String completeInfo;

    @Column(name = "academic_method_activity_type")
    private String academicMethodActivityType;

    @Column(name = "academic_method_activity_form")
    private String academicMethodActivityForm;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type")
    private ActivityType activityType;

    @OneToOne(targetEntity = Specialization.class)
    @JoinColumn(name="specialization_id", nullable=false)
    private Specialization specialization;

    @ManyToOne(targetEntity = AcademicDiscipline.class)
    @JoinColumn(name="academic_discipline_id", nullable=false)
    private AcademicDiscipline academicDiscipline;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
