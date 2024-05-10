package com.challenge.heyGongChallenge.video.domain.entity;

import com.challenge.heyGongChallenge.global.entity.BaseEntity;
import com.challenge.heyGongChallenge.notification.domain.type.EventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "video")
@Getter
@Setter
@NoArgsConstructor
public class Video extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoSeq;

    @Column
    private Long userSeq;

    @Column
    private String url;

    @Column
    private String name;

        
}