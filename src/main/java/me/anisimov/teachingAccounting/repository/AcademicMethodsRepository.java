package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicMethodsRepository extends JpaRepository<AcademicMethods,Long> {

    List<AcademicMethods> findAllByUser(Long userId);
}
