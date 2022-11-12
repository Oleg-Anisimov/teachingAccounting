package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
