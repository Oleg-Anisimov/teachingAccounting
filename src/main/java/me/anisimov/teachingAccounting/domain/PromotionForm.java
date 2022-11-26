package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promotion_form")
@SequenceGenerator(name = "promotion_form_seq_gen", sequenceName = "promotion_form_seq", allocationSize = 1)
public class PromotionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotion_form_seq")
    private Long id;

    @Column(name = "name")
    private String name;

}
