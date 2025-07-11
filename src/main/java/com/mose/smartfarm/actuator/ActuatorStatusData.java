package com.mose.smartfarm.actuator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActuatorStatusData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String device;
    private String status;
    private LocalDateTime updatedAt;

    public ActuatorStatusData(String device, String status) {
        this.device = device;
        this.status = status;
    }
}
