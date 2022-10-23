package com.smile.api.domain.base.contorller;

import com.smile.api.domain.base.entity.Member;
import com.smile.api.domain.base.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public long saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

}
