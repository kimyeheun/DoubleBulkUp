package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Gym;
import com.doubleBulkUp.gym.entity.GymFacilities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymFacilitiesRepository extends JpaRepository<GymFacilities, Gym> {
}
