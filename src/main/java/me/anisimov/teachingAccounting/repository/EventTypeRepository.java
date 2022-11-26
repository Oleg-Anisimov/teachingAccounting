package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType,Long> {
}
