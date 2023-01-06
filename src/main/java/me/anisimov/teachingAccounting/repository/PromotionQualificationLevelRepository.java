package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Educate;
import me.anisimov.teachingAccounting.domain.PromotionQualificationLevel;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionQualificationLevelRepository extends JpaRepository<PromotionQualificationLevel,Long> {
    List<Educate> findAllByUser(User user);
}
