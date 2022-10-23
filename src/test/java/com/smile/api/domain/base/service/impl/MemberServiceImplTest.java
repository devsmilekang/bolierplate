package com.smile.api.domain.base.service.impl;

import com.smile.api.domain.base.entity.Member;
import com.smile.api.domain.base.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Rollback(value = false)
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("멤버 저장")
    public void saveMember() {
        Member member = new Member();
        member.setAge(10);
        member.setName("Dave");

        long id = memberService.saveMember(member);

        Member memberById = memberService.findMemberById(id);

        assertEquals(member.getAge(), memberById.getAge());
        assertEquals(member.getName(), memberById.getName());
    }

    @Test
    @DisplayName("멤버 삭제")
    public void deleteMember() {
        Member member = new Member();
        member.setAge(10);
        member.setName("Dave");

        long id = memberService.saveMember(member);

        long deletedId = memberService.deleteMember(member);

        assertEquals(id, deletedId);
    }

    @Test
    @DisplayName("멤버 업데이트")
    public void updateMember() {

        Member member = new Member();
        member.setAge(10);
        member.setName("Dave");

        long id = memberService.saveMember(member);

        member.setAge(20);
        member.setName("Yoojin");

        memberService.updateMember(member);

        Member findMember = memberService.findMemberById(id);
        assertEquals(member.getName(), findMember.getName());
        assertEquals(member.getAge(), findMember.getAge());
    }

}