package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByLogin(String login);
}
