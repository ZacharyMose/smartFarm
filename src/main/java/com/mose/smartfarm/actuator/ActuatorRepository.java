package com.mose.smartfarm.actuator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuatorRepository extends JpaRepository<ActuatorStatusData, String> {

}
