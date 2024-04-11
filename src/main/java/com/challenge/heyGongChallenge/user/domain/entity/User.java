package com.challenge.heyGongChallenge.user.domain.entity;


import com.challenge.heyGongChallenge.global.entity.BaseEntity;
import com.challenge.heyGongChallenge.global.type.DeviceOsType;
import com.challenge.heyGongChallenge.user.domain.type.SnsType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users") // Define the table name; optional if you want it the same as the class name
@Getter // Lombok annotation to generate getters automatically
@Setter // Lombok annotation to generate setters automatically
@NoArgsConstructor // Lombok annotation to generate a no-args constructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(nullable = false)
    private String deviceId;

    @Column
    @Enumerated(EnumType.STRING)
    private DeviceOsType deviceOs;

    @Column
    private String userId;

    @Column
    @Enumerated(EnumType.STRING)
    private SnsType snsType;

    @Column
    private String snsId;

    @Column
    private String email;

    @Column
    private LocalDateTime deletedAt;

    @Column
    private Boolean alarm;

    @Column
    private String fcmToken;

    @Column
    private Boolean ads;

}