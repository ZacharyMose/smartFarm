package com.mose.smartfarm.sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<SensorData, Long> {
    Optional<SensorData>  findTopByOrderByTimestampDesc();
}
