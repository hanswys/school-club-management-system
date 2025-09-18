package com.personal.school_club_management_system.School_Club_Management_System.repository;

import com.personal.school_club_management_system.School_Club_Management_System.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {

}