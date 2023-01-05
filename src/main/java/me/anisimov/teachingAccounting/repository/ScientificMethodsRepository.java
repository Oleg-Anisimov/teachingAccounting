package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.ScientificMethods;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScientificMethodsRepository extends JpaRepository<ScientificMethods,Long> {

    List<ScientificMethods> findAllByUser(User user);
}
