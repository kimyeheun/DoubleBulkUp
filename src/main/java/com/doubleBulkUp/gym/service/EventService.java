package com.doubleBulkUp.gym.service;

import com.doubleBulkUp.gym.dto.EventBriefResponseDto;
import com.doubleBulkUp.gym.entity.Event;
import com.doubleBulkUp.gym.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<EventBriefResponseDto> findEventListDto() {
        List<Event> findAllEvent = eventRepository.findAll();
        List<EventBriefResponseDto> events = new ArrayList<>();
        for (Event event : findAllEvent) {
            EventBriefResponseDto gymResponse = new EventBriefResponseDto(event);
            if (eventRepository.existsEventByEventDateTimeAfter(LocalDateTime.now()))
                events.add(gymResponse);
        }
        return events;
    }
}
