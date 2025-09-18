// EventService.java
package com.personal.school_club_management_system.School_Club_Management_System.service;

import com.personal.school_club_management_system.School_Club_Management_System.model.Event;
import com.personal.school_club_management_system.School_Club_Management_System.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}