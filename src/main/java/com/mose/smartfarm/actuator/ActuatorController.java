package com.mose.smartfarm.actuator;

import com.mose.smartfarm.sensor.SensorData;
import com.mose.smartfarm.sensor.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/actuators")
public class ActuatorController {

    private final ActuatorService service;
    private final ActuatorRepository repository;

    @PostMapping("/control")
    public ResponseEntity<String> control(@RequestBody ActuatorStatusData status) {
        service.setStatus(status.getDevice(), status.getAction());
        return ResponseEntity.ok("Command sent");
    }

    @GetMapping("/status")
    public ResponseEntity<String> status(@RequestParam String device) {
        return  repository.findByDevice(device)
                .map(dev -> ResponseEntity.ok(dev.getAction()))
                .orElse(ResponseEntity.notFound().build());
    }
}
