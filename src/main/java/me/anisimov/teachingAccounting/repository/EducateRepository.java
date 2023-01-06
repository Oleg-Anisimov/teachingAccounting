package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducateRepository extends JpaRepository<Educate,Long> {

    List<Educate> findAllByUser(User user);

    Page<Educate> getAllByUser(User user, Pageable pageable);
}
