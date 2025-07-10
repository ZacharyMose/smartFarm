package com.mose.smartfarm.actuator;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActuatorResponse {
    private String device;
    private String status;
    private LocalDateTime time;
}
