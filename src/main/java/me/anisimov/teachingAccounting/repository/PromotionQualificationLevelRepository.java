package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.domain.PromotionQualificationLevel;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionQualificationLevelRepository extends JpaRepository<PromotionQualificationLevel,Long> {
    List<PromotionQualificationLevel> findAllByUser(User user);

    Page<PromotionQualificationLevel> getAllByUser(User user, Pageable pageable);
}
