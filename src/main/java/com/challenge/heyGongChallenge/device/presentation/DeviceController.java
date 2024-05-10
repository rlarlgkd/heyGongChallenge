package com.challenge.heyGongChallenge.device.presentation;

import com.challenge.heyGongChallenge.device.application.DeviceService;
import com.challenge.heyGongChallenge.device.domain.entity.Device;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;


    @Operation(summary = "디바이스 아이디에 맞는 기기 찾기", responses = {
            @ApiResponse(description = "The device", content = @Content(schema = @Schema(implementation = Device.class))),
            @ApiResponse(responseCode = "200", description = "Device found")
    })
    @GetMapping("/{deviceId}")
    public ResponseEntity<Device> getDeviceById(@PathVariable String deviceId) {
        Device device = deviceService.getDeviceById(deviceId);
        return ResponseEntity.ok(device);
    }

    @Operation(summary = "기기 목록 보기", responses = {
            @ApiResponse(description = "기기 목록", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "200", description = "Device found")
    })
    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    @GetMapping("/{deviceId}/control")
    public ResponseEntity<Void> getDeviceControlById(@PathVariable String deviceId) {
        return ResponseEntity.ok().build();
    }




}
