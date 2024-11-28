package com.koreait.Surl_project_11.domain.auth.auth.service;

import com.koreait.Surl_project_11.domain.member.entity.Member;
import com.koreait.Surl_project_11.grobal.app.AppConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@RequiredArgsConstructor
public class AuthTokenService {
    public String genToken(Member member, long expireSeconds) {
        Claims claims = Jwts.claims()
                .add("id", member.getId())
                .add("username", member.getUsername())
                .build();
        Date issuedAt = new Date();
        Date expiration = new Date(issuedAt.getTime() + expireSeconds * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, AppConfig.getJwtSecretKey())
                .compact();
    }
}