package com.mose.smartfarm.sensor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public void save(SensorData data) {
        repository.save(data);
    }

    public Optional<SensorData> getLatest() {
        return repository.findTopByOrderByTimestampDesc();
    }

    public List<SensorData> getAll() {
        return repository.findAll();
    }
}
