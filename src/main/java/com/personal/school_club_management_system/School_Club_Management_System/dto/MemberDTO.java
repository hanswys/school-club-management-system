package com.personal.school_club_management_system.School_Club_Management_System.dto;

import java.util.Set;

public class MemberDTO {
    private Long id;
    private String name;
    private String email;
    private String grade;
    private Set<Long> clubIds; // references to clubs
}