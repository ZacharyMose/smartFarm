package com.mose.smartfarm.actuator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActuatorRepository extends JpaRepository<ActuatorStatusData, Long> {
    Optional<ActuatorStatusData> findById(Long id);
    Optional<ActuatorStatusData> findTopByDeviceIgnoreCaseOrderByUpdatedAtDesc(String device);
}
