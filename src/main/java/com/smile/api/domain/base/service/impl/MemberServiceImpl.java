package com.smile.api.domain.base.service.impl;

import com.smile.api.domain.base.entity.Member;
import com.smile.api.domain.base.repository.MemberRepository;
import com.smile.api.domain.base.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    public final MemberRepository memberRepository;

    @Override
    public long saveMember(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    @Override
    public long deleteMember(Member member) {
        memberRepository.delete(member);
        return member.getId();
    }

    @Override
    public long updateMember(Member member) {
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }

    @Override
    public Member findMemberById(long id) {
        return memberRepository.findById(id).orElseThrow();
    }

}
