package com.doubleBulkUp.gym.repository;

import com.doubleBulkUp.gym.entity.Gym;
import com.doubleBulkUp.gym.entity.GymMappingEE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymMappingEERepository extends JpaRepository<GymMappingEE, Long> {
    public List<GymMappingEE> findByGym(Gym gym);
}
