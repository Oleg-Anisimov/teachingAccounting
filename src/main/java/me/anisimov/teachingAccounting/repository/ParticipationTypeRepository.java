package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.ParticipationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationTypeRepository extends JpaRepository<ParticipationType,Long> {
}
