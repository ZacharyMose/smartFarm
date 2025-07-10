package com.mose.smartfarm.actuator;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActuatorResponse {
    private String device;
    private String status;
    private LocalDateTime time;

    public ActuatorResponse(String device, String status, LocalDateTime time) {
        this.device = device;
        this.status = status;
        this.time = time;
    }
}
