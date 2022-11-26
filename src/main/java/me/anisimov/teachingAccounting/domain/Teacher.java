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

    @ManyToOne(targetEntity = EmploymentType.class)
    @JoinColumn(name="employment_id", nullable=false)
    private EmploymentType employmentType;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name="position_id", nullable=false)
    private Position position;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

}
