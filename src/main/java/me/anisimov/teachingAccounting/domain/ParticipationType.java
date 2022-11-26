package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participation_type")
@SequenceGenerator(name = "participation_type_seq_gen", sequenceName = "participation_type_seq", allocationSize = 1)
public class ParticipationType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participation_type_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
