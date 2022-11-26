package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
