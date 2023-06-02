package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Gym;
import com.doubleBulkUp.gym.entity.GymFacilities;
import com.doubleBulkUp.gym.entity.GymFacilitiesId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymFacilitiesRepository extends JpaRepository<GymFacilities, GymFacilitiesId> {
}
