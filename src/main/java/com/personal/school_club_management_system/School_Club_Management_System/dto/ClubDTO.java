package com.personal.school_club_management_system.School_Club_Management_System.dto;

import java.util.Set;
import java.util.List;

public class ClubDTO {
    private Long id;
    private String name;
    private String description;
    private String advisor;
    private Set<Long> memberIds; // references to members
    private List<Long> eventIds; // references to events
}