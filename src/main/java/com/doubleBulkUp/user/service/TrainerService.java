package com.doubleBulkUp.user.service;

import com.doubleBulkUp.gym.entity.Gym;
import com.doubleBulkUp.gym.repository.GymRepository;
import com.doubleBulkUp.user.dto.TrainerBriefResponseDto;
import com.doubleBulkUp.user.entity.Trainer;
import com.doubleBulkUp.user.repository.PersonRepository;
import com.doubleBulkUp.user.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final GymRepository gymRepository;


    public List<TrainerBriefResponseDto> findAll(){
        return trainerRepository.findAll()
                .stream()
                .map(TrainerBriefResponseDto::new)
                .collect(Collectors.toList());
    }


    public List<TrainerBriefResponseDto> search(String keyword) {
        List<Gym> gyms = gymRepository.findByGymNameContaining(keyword);
        List<TrainerBriefResponseDto> trainers = new ArrayList<>();
        for(Gym g : gyms) {
            System.out.println(g.getGymName());
            List<Trainer> trainerList = trainerRepository.findByGymName(g);
            for(Trainer t : trainerList) {
                System.out.println("hi");
                System.out.println(t.getGymName());
                System.out.println(t.getTrainerId());
                trainers.add(new TrainerBriefResponseDto(t));
            }
        }
        return trainers;
    }

}