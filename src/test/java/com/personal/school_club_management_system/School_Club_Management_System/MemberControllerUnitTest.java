package com.personal.school_club_management_system.School_Club_Management_System;

import com.personal.school_club_management_system.School_Club_Management_System.controller.MemberController;
import com.personal.school_club_management_system.School_Club_Management_System.model.Member;
import com.personal.school_club_management_system.School_Club_Management_System.repository.MemberRepository;

import com.personal.school_club_management_system.School_Club_Management_System.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberControllerUnitTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void shouldReturnMemberWhenIdExists() {
        Member mockMember = new Member();
        mockMember.setId(1L);
        mockMember.setName("Alice");
        when(memberRepository.findById(1L)).thenReturn(Optional.of(mockMember));

        Member result = memberService.findById(1L);

        assertEquals("Alice", result.getName());
        verify(memberRepository).findById(1L);
    }
}
