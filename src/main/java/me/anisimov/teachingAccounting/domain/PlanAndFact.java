package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="plan_and_fact")
@SequenceGenerator(name = "plan_and_fact_seq_gen", sequenceName = "plan_and_fact_seq", allocationSize = 1)
public class PlanAndFact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_and_fact_seq")
    private Long id;

    @Column(name = "plan")
    private String plan;

    @Column(name = "fact")
    private String fact;

}
