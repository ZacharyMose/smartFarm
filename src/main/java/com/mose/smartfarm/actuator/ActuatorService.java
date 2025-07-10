package com.mose.smartfarm.actuator;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActuatorService {
    private final ActuatorRepository repository;

    public ActuatorService(ActuatorRepository repository) {
        this.repository = repository;
    }

    public void setStatus(String device, String action) {
        repository.save(new ActuatorStatusData(device, action));
    }

    public ActuatorResponse getStatus(String device) {
        ActuatorStatusData actuator = repository
                .findTopByDeviceOrderByUpdatedAtDesc(device.toLowerCase())
                .orElse(new ActuatorStatusData(device, "unknown"));

        return new ActuatorResponse(actuator.getDevice(),actuator.getStatus(),actuator.getUpdatedAt());
    }
}
