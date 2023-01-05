package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.AcademicProduction;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicProductionRepository extends JpaRepository<AcademicProduction,Long> {

    List<AcademicProduction> findAllByUser(User user);
}
