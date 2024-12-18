package com.koreait.Surl_project_11.domain.surl.surl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.koreait.Surl_project_11.domain.member.entity.Member;
import com.koreait.Surl_project_11.grobal.jpa.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Surl extends BaseTime {
    @ManyToOne
    @JsonIgnore
    private Member author;
    private String body;
    private String url;
    @Setter(AccessLevel.NONE)
    private long count;

    public void increaseCount() {
        count++;
    }

}