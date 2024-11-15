package com.koreait.Surl_project_11.domain.member.controller;

import com.koreait.Surl_project_11.domain.member.entity.Member;
import com.koreait.Surl_project_11.domain.member.service.MemberService;
import com.koreait.Surl_project_11.grobal.eceptions.GlobalException;
import com.koreait.Surl_project_11.grobal.rsData.RsData;
import com.koreait.Surl_project_11.standard.util.Ut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    @ResponseBody
    public RsData<Member> join(
            String username, String password, String nickname
    ) {
        if (Ut.str.isBlank(username)) {
            throw new GlobalException("400-1", "username을 입력해");
        }

        if (Ut.str.isBlank(password)) {
            throw new GlobalException("400-2", "password을 입력해");
        }

        if (Ut.str.isBlank(nickname)) {
            throw new GlobalException("400-3", "nickname을 입력해");
        }

        return memberService.join(username, password, nickname);

    }

    @GetMapping("/testThrowIllegalArgumentException")
    @ResponseBody
    public RsData<Member> testThrowIllegalArgumentException() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }
}