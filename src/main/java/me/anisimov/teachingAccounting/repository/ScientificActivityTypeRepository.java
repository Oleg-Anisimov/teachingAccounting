package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.ScientificActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScientificActivityTypeRepository extends JpaRepository<ScientificActivityType,Long> {
}
