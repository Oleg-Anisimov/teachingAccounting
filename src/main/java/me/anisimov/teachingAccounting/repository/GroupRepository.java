package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
