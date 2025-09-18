// ClubService.java
package com.personal.school_club_management_system.School_Club_Management_System.service;

import com.personal.school_club_management_system.School_Club_Management_System.model.Club;
import com.personal.school_club_management_system.School_Club_Management_System.repository.ClubRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    public Club save(Club club) {
        return clubRepository.save(club);
    }

    public Club findById(Long id) {
        return clubRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        clubRepository.deleteById(id);
    }
}