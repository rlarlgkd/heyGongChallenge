package com.challenge.heyGongChallenge.device.domain.entity;

import com.challenge.heyGongChallenge.device.domain.type.CameraModeType;
import com.challenge.heyGongChallenge.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "device")
@Getter
@Setter
@NoArgsConstructor
public class Device extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceSeq;

    @Column
    private Long userSeq;

    @Column
    private String deviceId;

    @Column
    private String deviceModel;

    @Column
    private String deviceName;

    @Column
    private Boolean soundMode;

    @Column
    private Boolean streamActive;

    @Column
    @Enumerated(EnumType.STRING)
    private CameraModeType cameraMode;

    @Column
    private String fcmToken;

    @Column
    private int temperature;

    @Column
    private int battery;
}
