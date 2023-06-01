package com.doubleBulkUp.gym.service;

import com.doubleBulkUp.user.entity.Ceo;
import com.doubleBulkUp.user.service.UserService;
import com.doubleBulkUp.gym.dto.CreateGymRequestDto;
import com.doubleBulkUp.gym.dto.GymDetailResponseDto;
import com.doubleBulkUp.gym.dto.GymListResponseDto;
import com.doubleBulkUp.gym.entity.Gym;
import com.doubleBulkUp.gym.entity.GymFacilities;
import com.doubleBulkUp.gym.repository.GymFacilitiesRepository;
import com.doubleBulkUp.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GymService {
    private final GymRepository gymRepository;
    private final GymFacilitiesRepository gymFacilitiesRepository;
    private final UserService userService;

    public void save(CreateGymRequestDto request){
        Gym gym = new Gym();
        gym.setGymName(request.getGymName());
        gym.setGymLocation(request.getGymLocation());
        gym.setGymPeople(request.getGymPeople());
        gym.setGymPrice(request.getGymPrice());
        gym.setGymUsableTime(request.getGymUsableTime());

        Ceo findCeo = userService.findCeoByPersonId(request.getCeoId());
        gym.setCeo(findCeo);

        gymRepository.save(gym);
    }

    public Gym findById(String gymId){
        return gymRepository.findById(gymId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public GymDetailResponseDto findGymDetailDtoById(String gymId){
        Gym gym = findById(gymId);
        GymDetailResponseDto response = new GymDetailResponseDto();
        response.setGymName(gym.getGymName());
        response.setGymLocation(gym.getGymLocation());
        response.setGymPeople(gym.getGymPeople());
        response.setGymPrice(gym.getGymPrice());
        response.setGymUsableTime(gym.getGymUsableTime());
        //todo:변경
        response.setCeoId(gym.getCeo().toString());

        GymFacilities gymFacilities = gymFacilitiesRepository.findById(gym).orElseGet(null);
        if(Objects.nonNull(gymFacilities)){
            response.setShowerBoothCnt(gymFacilities.getShowerBoothCnt());
            response.setFittingRoom(gymFacilities.getFittingRoom());
            response.setClothes(gymFacilities.getClothes());
            response.setLockerCnt(gymFacilities.getLockerCnt());
            response.setHowToAttendance(gymFacilities.getHowToAttendance());
        }

        return response;
    }

    public List<GymListResponseDto> findAllGymDto(){
        return gymRepository.findAll()
                .stream()
                .map(GymListResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<Gym> findAll(){
        return gymRepository.findAll();
    }
}
