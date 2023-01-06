package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.ScientificMethods;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScientificMethodsRepository extends JpaRepository<ScientificMethods,Long> {

    List<ScientificMethods> findAllByUser(User user);

    Page<ScientificMethods> getAllByUser(User user, Pageable pageable);
}
