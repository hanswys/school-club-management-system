// ClubController.java
package com.personal.school_club_management_system.School_Club_Management_System.controller;

import com.personal.school_club_management_system.School_Club_Management_System.model.Club;
import com.personal.school_club_management_system.School_Club_Management_System.service.ClubService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<Club> getAll() {
        return clubService.findAll();
    }

    @GetMapping("/{id}")
    public Club getById(@PathVariable Long id) {
        return clubService.findById(id);
    }

    @PostMapping
    public Club create(@RequestBody Club club) {
        return clubService.save(club);
    }

    @PutMapping("/{id}")
    public Club update(@PathVariable Long id, @RequestBody Club club) {
        club.setId(id);
        return clubService.save(club);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clubService.deleteById(id);
    }
}