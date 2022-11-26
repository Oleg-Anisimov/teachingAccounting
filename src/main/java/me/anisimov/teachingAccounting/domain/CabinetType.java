package me.anisimov.teachingAccounting.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cabinet_type")
@SequenceGenerator(name = "cabinet_type_seq_gen", sequenceName = "cabinet_type_seq", allocationSize = 1)
public class CabinetType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cabinet_type_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cabinets")
    private List<Cabinet> cabinets;
}

