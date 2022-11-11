package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicDisciplineRepository extends JpaRepository<AcademicDiscipline, Long> {
}
