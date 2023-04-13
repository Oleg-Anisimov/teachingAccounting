package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
