package com.mose.smartfarm.sensor;

import com.mose.smartfarm.actuator.ActuatorService;
import com.mose.smartfarm.actuator.ActuatorStatusData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
public class SensorController {
    private final SensorService service;

    @PostMapping("/submit")
    public ResponseEntity<String> submit(@RequestBody SensorData data) {
        service.save(data);
        return ResponseEntity.ok("Sensor data received");
    }

    @GetMapping("/latest")
    public ResponseEntity<SensorData> getLatest() {
        return service.getLatest()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/all")
    public List<SensorData> all() {
        return service.getAll();
    }
}
