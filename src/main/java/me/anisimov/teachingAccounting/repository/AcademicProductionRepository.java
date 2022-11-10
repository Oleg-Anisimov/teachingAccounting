package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicProductionRepository extends JpaRepository<AcademicProduction,Long> {
}