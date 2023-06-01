package com.doubleBulkUp.user.repository;

import com.doubleBulkUp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsByPersonId(String personId);
    Optional<User> findByPersonId(String personId);
}
