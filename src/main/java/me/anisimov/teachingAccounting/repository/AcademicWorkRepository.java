package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicWorkRepository extends JpaRepository<AcademicWork,Long> {
}
