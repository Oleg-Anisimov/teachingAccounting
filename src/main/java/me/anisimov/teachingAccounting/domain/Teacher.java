package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.Category;
import me.anisimov.teachingAccounting.domain.Enums.EmploymentType;
import me.anisimov.teachingAccounting.domain.Enums.Position;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="teacher")
@SequenceGenerator(name = "teacher_seq_gen", sequenceName = "teacher_seq", allocationSize = 1)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_seq")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "certification_date")
    private LocalDate certificationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type")
    private EmploymentType employmentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Enumerated(EnumType.STRING)
    @Column(name="category")
    private Category category;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

}
