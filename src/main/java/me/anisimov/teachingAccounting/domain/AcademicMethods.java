package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="academic_methods")
@SequenceGenerator(name = "academic_methods_seq_gen", sequenceName = "methods_work_seq", allocationSize = 1)
public class AcademicMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "methods_work_seq")
    private Long id;

    @Column(name = "dead_line")
    private LocalDate deadLine;

    @Column(name = "complete_info")
    private String completeInfo;

    @ManyToOne(targetEntity = AcademicMethodsActivityType.class)
    @JoinColumn(name="academic_method_activity_type_id", nullable=false)
    private AcademicMethodsActivityType academicMethodActivityType;

    @ManyToOne(targetEntity = AcademicMethodsActivityForm.class)
    @JoinColumn(name="academic_method_activity_form_id", nullable=false)
    private AcademicMethodsActivityForm academicMethodActivityForm;

    @ManyToOne(targetEntity = AcademicWorkActivityType.class)
    @JoinColumn(name="activityType_id", nullable=false)
    private AcademicWorkActivityType academicWorkActivityType;

    @OneToOne(targetEntity = Specialization.class)
    @JoinColumn(name="specialization_id", nullable=false)
    private Specialization specialization;

    @ManyToOne(targetEntity = AcademicDiscipline.class)
    @JoinColumn(name="academic_discipline_id", nullable=false)
    private AcademicDiscipline academicDiscipline;



}
