package com.personal.school_club_management_system.School_Club_Management_System.dto;

import java.time.LocalDate;

public class EventDTO {
    private Long id;
    private String title;
    private LocalDate date;
    private String description;
    private Long clubId; // reference to parent club
}