package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.OrganizedActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizedActivityTypeRepository extends JpaRepository<OrganizedActivityType,Long> {
}
