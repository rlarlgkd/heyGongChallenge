package com.challenge.heyGongChallenge.user.domain.entity;


import com.challenge.heyGongChallenge.global.entity.BaseEntity;
import com.challenge.heyGongChallenge.global.type.DeviceOsType;
import com.challenge.heyGongChallenge.user.domain.type.RoleType;
import com.challenge.heyGongChallenge.user.domain.type.SnsType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "UsersBuilder")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column
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

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleType role;



    public static UsersBuilder createUser(String userId, String email, String deviceId, String name) {
        return User.builder()
                .userId(userId)
                .email(email)
                .deviceId(deviceId)
                // Set default values
                .deviceOs(DeviceOsType.AOS) // Assume DeviceOsType.DEFAULT is a valid enum value
                .snsType(SnsType.GOOGLE) // Assume SnsType.NONE is a valid enum value
                .alarm(false)
                .ads(false)
                .name(name)
                .role(RoleType.ROLE_USER)
                .deletedAt(null); // Explicitly setting null if you want to avoid defaulting to current time
    }
}