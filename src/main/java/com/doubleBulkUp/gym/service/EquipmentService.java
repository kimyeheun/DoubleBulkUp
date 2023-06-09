package com.doubleBulkUp.gym.service;

import com.doubleBulkUp.gym.dto.EquipmentDto;
import com.doubleBulkUp.gym.entity.Gym;
import com.doubleBulkUp.gym.entity.GymMappingEE;
import com.doubleBulkUp.gym.repository.ExerciseEquipmentRepository;
import com.doubleBulkUp.gym.repository.GymMappingEERepository;
import com.doubleBulkUp.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentService {

    private final ExerciseEquipmentRepository equipmentRepository;
    private final GymRepository gymRepository;
    private final GymMappingEERepository gymEeRepository;

    public boolean saveEquipment(String gymName, EquipmentDto equipmentDto) {
        Gym gym = gymRepository.findByGymName(gymName).get();

        String[] result = equipmentDto.getListName().split(",");

        for(String r : result) {
            GymMappingEE gymMappingEE = new GymMappingEE();
            gymMappingEE.setGym(gym);
            gymMappingEE.setCount(1);
            gymMappingEE.setExerciseEquipment(equipmentRepository.findByEquipmentName(r).get());
            gymEeRepository.save(gymMappingEE);
        }

        return gymEeRepository.existsByGym(gym);
    }

}
