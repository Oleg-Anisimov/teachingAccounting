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
@Table(name ="users")
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @JsonIgnore
    @OneToOne(mappedBy = "userId")
    private Teacher teacher;
}
