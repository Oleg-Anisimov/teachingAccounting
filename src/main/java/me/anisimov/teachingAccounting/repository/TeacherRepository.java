package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
