package com.challenge.heyGongChallenge.notification.domain.entity;

import com.challenge.heyGongChallenge.global.entity.BaseEntity;
import com.challenge.heyGongChallenge.notification.domain.type.EventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
@Getter
@Setter
@NoArgsConstructor
public class Notification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationSeq;

    @Column
    private Long userSeq;

    @Column
    @Enumerated(EnumType.STRING)
    private EventType type;

    @Column
    private boolean readStatus;

    @Column
    private String content;

    @Column
    private LocalDateTime notificationAt;

    @Column
    private Long deviceSeq;

}