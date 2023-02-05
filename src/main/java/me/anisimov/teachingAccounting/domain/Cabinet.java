package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="cabinet")
@SequenceGenerator(name = "cabinet_seq_gen", sequenceName = "cabinet_seq", allocationSize = 1)
public class Cabinet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cabinet_seq")
    private Long id;

    @Column(name = "cabinet_name")
    private String cabinetName;

    @Column(name = "cabinet_type")
    private String cabinetType;
}