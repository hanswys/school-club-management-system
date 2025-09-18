// MemberController.java
package com.personal.school_club_management_system.School_Club_Management_System.controller;

import com.personal.school_club_management_system.School_Club_Management_System.model.Member;
import com.personal.school_club_management_system.School_Club_Management_System.service.MemberService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PostMapping
    public Member create(@RequestBody Member member) {
        return memberService.save(member);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member member) {
        member.setId(id);
        return memberService.save(member);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.deleteById(id);
    }
}