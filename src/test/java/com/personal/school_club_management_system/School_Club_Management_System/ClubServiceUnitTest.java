package com.personal.school_club_management_system.School_Club_Management_System;

import com.personal.school_club_management_system.School_Club_Management_System.repository.ClubRepository;
import com.personal.school_club_management_system.School_Club_Management_System.service.ClubService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.personal.school_club_management_system.School_Club_Management_System.model.Club;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClubServiceUnitTest {

    @Mock
    ClubRepository repo;

    @InjectMocks
    ClubService service;

    @Test
    void testFindAll(){
        Club mockClub = new Club();
        mockClub.setId(1L);
        mockClub.setName("Club");
        mockClub.setAdvisor("Hans");
        mockClub.setDescription("Test");
        mockClub.setEvents(null);
        mockClub.setMembers(null);

        Club mockClub2 = new Club();
        mockClub2.setId(2L);
        mockClub2.setName("Club2");
        mockClub2.setAdvisor("Hans2");
        mockClub2.setDescription("Test2");
        mockClub2.setEvents(null);
        mockClub2.setMembers(null);

        List<Club> mockListClubs = new ArrayList<>();
        mockListClubs.add(mockClub);
        mockListClubs.add(mockClub2);

        when(repo.findAll()).thenReturn(mockListClubs);

        List<Club> result = service.findAll();

        assertNotNull(result);                        // the result should not be null
        assertEquals(2, result.size());               // list size should match
        assertEquals("Club", result.get(0).getName()); // first club's name
        assertEquals("Hans", result.get(0).getAdvisor()); // first club's advisor
        assertEquals("Test", result.get(0).getDescription()); // first club's description

        assertEquals("Club2", result.get(1).getName());   // second club's name
        assertEquals("Hans2", result.get(1).getAdvisor()); // second club's advisor
        assertEquals("Test2", result.get(1).getDescription()); // second club's description

        verify(repo).findAll();
    }

    @Test
    void testSave(){
        Club mockClub = new Club();
        mockClub.setId(1L);
        mockClub.setName("Club");
        mockClub.setAdvisor("Hans");
        mockClub.setDescription("Test");
        mockClub.setEvents(null);
        mockClub.setMembers(null);

        service.save(mockClub);
        verify(repo).save(mockClub);


    }

    @Test
    void testFindById(){
        Club mockClub = new Club();
        mockClub.setId(1L);
        mockClub.setName("Club");
        mockClub.setAdvisor("Hans");
        mockClub.setDescription("Test");
        mockClub.setEvents(null);
        mockClub.setMembers(null);
        when(repo.findById(1L)).thenReturn(Optional.of(mockClub));

        Club result = service.findById(1L);

        assertEquals("Club", result.getName());
        assertEquals("Hans", result.getAdvisor());
        assertEquals("Test", result.getDescription());
        assertNull(result.getEvents());
        assertNull(result.getMembers());
        verify(repo).findById(1L);

    }

    @Test
    void testDeleteById(){
        long id = 1L;
        service.deleteById(id);
        verify(repo).deleteById(1L);
    }
}
