package me.anisimov.teachingAccounting.repository;


import me.anisimov.teachingAccounting.domain.WorkVector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkVectorRepository extends JpaRepository<WorkVector,Long> {
}
