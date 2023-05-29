package com.doubleBulkUp.User.repository;

import com.doubleBulkUp.User.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findByPersonId(String personId);
    Boolean existsPersonByPersonId(String personId);
}
