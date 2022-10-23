package com.smile.api.domain.base.service;

import com.smile.api.domain.base.entity.Member;

public interface MemberService{

    long saveMember(Member member);

    long deleteMember(Member member);

    long updateMember(Member member);

    Member findMemberById(long id);

}
