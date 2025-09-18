package com.personal.school_club_management_system.School_Club_Management_System.repository;

import com.personal.school_club_management_system.School_Club_Management_System.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
