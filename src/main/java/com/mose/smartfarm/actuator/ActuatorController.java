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
        if (status == null || status.getDevice() == null || status.getStatus() == null) {
            return ResponseEntity.badRequest().body("Device or status is missing.");
        }

        String device = status.getDevice().toLowerCase();
        String action = status.getStatus().toLowerCase();

        if (!action.equals("on") && !action.equals("off")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'on' or 'off'.");
        }

        try {
            service.setStatus(device, action);
            return ResponseEntity.ok("Device " + device + " turned " + action);
        } catch (Exception e) {
            e.printStackTrace(); // Log to backend
            return ResponseEntity.internalServerError().body("Failed to control device.");
        }
    }

    @GetMapping("/status")
    public ResponseEntity<ActuatorResponse> status(@RequestParam String device) {
        ActuatorResponse response = service.getStatus(device);
        return ResponseEntity.ok(response);
    }
}
