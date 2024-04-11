package com.challenge.heyGongChallenge.device.application;

import com.challenge.heyGongChallenge.device.domain.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }



}
