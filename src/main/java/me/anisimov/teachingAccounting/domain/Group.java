package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="groups")
@SequenceGenerator(name = "group_seq_gen", sequenceName = "group_seq", allocationSize = 1)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    private Long id;

    @Column(name="group_name")
    private String groupName;
    @Override
    public String toString() {
        return "Group [id=" + id + ", groupName=" + groupName + "]";
    }

}
