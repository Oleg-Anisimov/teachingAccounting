package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
