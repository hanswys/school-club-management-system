// EventController.java
package com.personal.school_club_management_system.School_Club_Management_System.controller;

import com.personal.school_club_management_system.School_Club_Management_System.model.Event;
import com.personal.school_club_management_system.School_Club_Management_System.service.EventService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
        return eventService.save(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.deleteById(id);
    }
}