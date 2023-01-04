package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.OrganizedMethods;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizedMethodsRepository extends JpaRepository<OrganizedMethods,Long> {

    List<OrganizedMethods> findAllByUser(User user);

    Page<OrganizedMethods> getAllByUser(User user, Pageable pageable);
}
