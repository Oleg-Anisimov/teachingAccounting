package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.EventLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventLevelRepository extends JpaRepository<EventLevel,Long> {
}
