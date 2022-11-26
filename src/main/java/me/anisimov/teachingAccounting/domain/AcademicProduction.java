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
@Table(name ="academic_production")
@SequenceGenerator(name = "academic_production_seq_gen", sequenceName = "academic_production_seq", allocationSize = 1)
public class AcademicProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_production_seq")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "result")
    private String result;

    @ManyToOne(targetEntity = Cabinet.class)
    @JoinColumn(name="cabinet_id", nullable=false)
    private Cabinet cabinet;

    @ManyToOne(targetEntity = AcademicWorkActivityType.class)
    @JoinColumn(name="activityType_id", nullable=false)
    private AcademicWorkActivityType academicWorkActivityType;

    @ManyToOne(targetEntity = AcademicProductionActivityForm.class)
    @JoinColumn(name="academic_production_activity_form_id", nullable=false)
    private AcademicProductionActivityForm academicProductionActivityForm;

    @OneToOne(targetEntity = Specialization.class)
    @JoinColumn(name="specialization_id", nullable=false)
    private Specialization specialization;

}
