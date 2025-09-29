package com.personal.school_club_management_system.School_Club_Management_System;

import com.personal.school_club_management_system.School_Club_Management_System.model.Club;
import com.personal.school_club_management_system.School_Club_Management_System.model.Member;
import com.personal.school_club_management_system.School_Club_Management_System.repository.ClubRepository;
import com.personal.school_club_management_system.School_Club_Management_System.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClubSystemTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testCreateClubAndAddMember() {
        // 1️⃣ Create a Club via API
        Club club = new Club();
        club.setName("Chess Club");
        club.setAdvisor("Hans");
        club.setDescription("Chess for beginners");

        ResponseEntity<Club> clubResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/clubs",
                club,
                Club.class
        );

        assertTrue(clubResponse.getStatusCode().is2xxSuccessful());
        assertNotNull(clubResponse.getBody().getId());

        Long clubId = clubResponse.getBody().getId();

        // 2️⃣ Create a Member via API
        Member member = new Member();
        member.setName("Alice");

        ResponseEntity<Member> memberResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/members",
                member,
                Member.class
        );

        assertTrue(memberResponse.getStatusCode().is2xxSuccessful());
        assertNotNull(memberResponse.getBody().getId());

        Long memberId = memberResponse.getBody().getId();

        // 3️⃣ Verify club exists in DB
        Club savedClub = clubRepository.findById(clubId).orElse(null);
        assertNotNull(savedClub);
        assertEquals("Chess Club", savedClub.getName());
        assertEquals("Hans", savedClub.getAdvisor());

        // 4️⃣ Verify member exists in DB
        Member savedMember = memberRepository.findById(memberId).orElse(null);
        assertNotNull(savedMember);
        assertEquals("Alice", savedMember.getName());
    }
}