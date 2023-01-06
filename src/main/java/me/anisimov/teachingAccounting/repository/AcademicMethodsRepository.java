package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicMethodsRepository extends JpaRepository<AcademicMethods,Long> {

    List<AcademicMethods> findAllByUser(User user);
    Page<AcademicMethods> getAllByUser(User user, Pageable pageable);
}
