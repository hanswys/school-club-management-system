package com.personal.school_club_management_system.School_Club_Management_System;

import com.personal.school_club_management_system.School_Club_Management_System.model.Club;
import com.personal.school_club_management_system.School_Club_Management_System.repository.ClubRepository;
import com.personal.school_club_management_system.School_Club_Management_System.service.ClubService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional  // rolls back DB changes after each test
class ClubServiceIntegrationTest {

    @Autowired
    private ClubService service;

    @Autowired
    private ClubRepository repo;

    @Test
    void testCreateAndFindAllClubs() {
        // Create a new club
        Club club1 = new Club();
        club1.setName("Chess Club");
        club1.setAdvisor("Hans");
        club1.setDescription("Chess for beginners");

        Club club2 = new Club();
        club2.setName("Drama Club");
        club2.setAdvisor("Alice");
        club2.setDescription("Acting and plays");

        service.save(club1);
        service.save(club2);

        // Fetch all clubs from service
        List<Club> clubs = service.findAll();

        assertNotNull(clubs);
        assertEquals(2, clubs.size());

        assertTrue(clubs.stream().anyMatch(c -> c.getName().equals("Chess Club")));
        assertTrue(clubs.stream().anyMatch(c -> c.getName().equals("Drama Club")));
    }

    @Test
    void testDeleteClub() {
        Club club = new Club();
        club.setName("Science Club");
        club.setAdvisor("Bob");
        service.save(club);

        Long id = club.getId();
        assertNotNull(repo.findById(id).orElse(null));

        service.deleteById(id);

        assertFalse(repo.findById(id).isPresent());
    }
}
