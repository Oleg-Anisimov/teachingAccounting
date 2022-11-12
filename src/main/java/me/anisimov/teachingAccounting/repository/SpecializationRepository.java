package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization,Long> {
}
