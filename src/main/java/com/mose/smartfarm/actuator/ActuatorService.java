package com.mose.smartfarm.actuator;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ActuatorService {
    private final ActuatorRepository repository;

    public ActuatorService(ActuatorRepository repository) {
        this.repository = repository;
    }

    public void setStatus(String device, String action, LocalDateTime updatedAt) {
        repository.save(new ActuatorStatusData(device.toLowerCase(), action, updatedAt));
    }

    public ActuatorResponse getStatus(String device) {
        ActuatorStatusData actuator = repository
                .findTopByDeviceOrderByUpdatedAtDesc(device.toLowerCase())
                .orElse(new ActuatorStatusData(device,"off",LocalDateTime.now()));
        System.out.println("All devices in DB:");
        repository.findAll().forEach(System.out::println);

        return new ActuatorResponse(actuator.getDevice(),actuator.getStatus(),actuator.getUpdatedAt());
    }
}
