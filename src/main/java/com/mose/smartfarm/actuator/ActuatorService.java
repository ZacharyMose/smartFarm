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

    public Optional<ActuatorStatusData> getStatus(String device) {
        return repository.findById(device);
    }
}
