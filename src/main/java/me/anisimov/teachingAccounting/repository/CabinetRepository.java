package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinetRepository extends JpaRepository<Cabinet,Long> {
}
