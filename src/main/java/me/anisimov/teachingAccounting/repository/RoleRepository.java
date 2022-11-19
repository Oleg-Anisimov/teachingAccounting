package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
