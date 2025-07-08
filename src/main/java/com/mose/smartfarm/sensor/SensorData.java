package com.mose.smartfarm.sensor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class SensorData {
    @Id
    @GeneratedValue
    private Long id;

    private float temperature;
    private float humidity;
    private int lightIntensity;
    private int soilMoisture;
    private LocalDateTime timestamp = LocalDateTime.now();
}
