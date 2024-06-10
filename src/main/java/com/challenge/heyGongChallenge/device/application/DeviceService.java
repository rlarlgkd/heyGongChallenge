package com.challenge.heyGongChallenge.device.application;

import com.challenge.heyGongChallenge.device.domain.entity.Device;
import com.challenge.heyGongChallenge.device.domain.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;



    @Transactional(readOnly = true)
    public Device getDeviceById(String deviceId) {

        return deviceRepository.findByDeviceId(deviceId);

    }

    @Transactional(readOnly = true)
    public List<Device> getAllDevices() {

        return deviceRepository.findAll();

    }

    @Transactional
    public Device saveOrUpdateDevice(Device device) {

        return deviceRepository.save(device);

    }



}
