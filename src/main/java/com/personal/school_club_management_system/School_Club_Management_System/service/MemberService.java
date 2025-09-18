// MemberService.java
package com.personal.school_club_management_system.School_Club_Management_System.service;

import com.personal.school_club_management_system.School_Club_Management_System.model.Member;
import com.personal.school_club_management_system.School_Club_Management_System.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}