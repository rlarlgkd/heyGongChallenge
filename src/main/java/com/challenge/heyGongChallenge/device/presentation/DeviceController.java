package com.challenge.heyGongChallenge.device.presentation;

import com.challenge.heyGongChallenge.device.application.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

//    public DeviceController(DeviceService deviceService){
//        this.deviceService = deviceService;
//    }


}
