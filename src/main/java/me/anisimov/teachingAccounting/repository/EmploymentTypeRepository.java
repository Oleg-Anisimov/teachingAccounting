package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTypeRepository extends JpaRepository<EmploymentType,Long> {
}
