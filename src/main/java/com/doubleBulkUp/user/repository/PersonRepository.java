package com.doubleBulkUp.user.repository;

import com.doubleBulkUp.user.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findById(String personId);
    Boolean existsPersonById(String personId);
}
