package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
