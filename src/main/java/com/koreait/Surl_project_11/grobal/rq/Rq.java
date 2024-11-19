package com.koreait.Surl_project_11.grobal.rq;

import com.koreait.Surl_project_11.domain.member.entity.Member;
import com.koreait.Surl_project_11.domain.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;
    private final MemberService memberService;

    public Member getMember() {
        return memberService.getReferenceById(1L);
    }
    public String getCurrentUrlPath() {
        return req.getRequestURI();
    }
    public void setStatusCode(int statusCode) {
        resp.setStatus(statusCode);
    }
}