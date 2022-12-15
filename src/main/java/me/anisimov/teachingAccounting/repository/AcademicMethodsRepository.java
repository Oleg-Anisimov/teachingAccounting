package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicMethodsRepository extends JpaRepository<AcademicMethods,Long> {

    List<AcademicMethods> findAllByUser(User user);
}
