package com.challenge.heyGongChallenge.token.domain.entity;

import com.challenge.heyGongChallenge.global.entity.BaseEntity;
import com.challenge.heyGongChallenge.notification.domain.type.EventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "token")
@Getter
@Setter
@NoArgsConstructor
public class Token extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String refreshToken;

    @Column
    private Long userSeq;
}