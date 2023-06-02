package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Event;
import com.doubleBulkUp.gym.entity.EventId;
import com.doubleBulkUp.gym.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, EventId> {

    List<Event> findByGym(Gym gym);
    List<Event> findByGymGymName(String gymName);

    List<Event> findByEventDateTimeAfterAndGym(LocalDateTime now, Gym gym);

    Boolean existsEventByEventDateTimeAfterAndGym(LocalDateTime now, Gym gym);
}
