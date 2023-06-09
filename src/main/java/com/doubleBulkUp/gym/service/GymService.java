package com.doubleBulkUp.gym.service;

import com.doubleBulkUp.gym.dto.*;
import com.doubleBulkUp.gym.entity.*;
import com.doubleBulkUp.gym.repository.*;
import com.doubleBulkUp.user.dto.TrainerBriefResponseDto;
import com.doubleBulkUp.user.entity.Ceo;
import com.doubleBulkUp.user.repository.TrainerRepository;
import com.doubleBulkUp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymService {
    private final GymRepository gymRepository;
    private final GymFacilitiesRepository gymFacilitiesRepository;
    private final GymMappingEERepository gymMappingEERepository;
    private final ExerciseEquipmentRepository exerciseEquipmentRepository;
    private final EEMappingESRepository eeMappingESRepository;
    private final ExerciseSupplementRepository exerciseSupplementRepository;
    private final EventRepository eventRepository;
    private final TrainerRepository trainerRepository;
    private final UserService userService;

    public List<GymBriefResponseDto> findGymListDto(Boolean queryEvent){
        List<Gym> findAllGym = gymRepository.findAll();
        if(!queryEvent){
            return gymRepository.findAll()
                    .stream()
                    .map(GymBriefResponseDto::new)
                    .collect(Collectors.toList());
        }
        List<GymBriefResponseDto> gyms = new ArrayList<>();
        for (Gym gym : findAllGym) {
            GymBriefResponseDto gymResponse = new GymBriefResponseDto(gym);
            if(eventRepository.existsEventByEventDateTimeAfterAndGym(LocalDateTime.now(), gym))
                gyms.add(gymResponse);
        }
        return gyms;
    }

    public List<GymBriefResponseDto> search(String location) {
        return gymRepository.findByGymLocationContaining(location)
                .stream()
                .map(GymBriefResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
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
        response.setCeoId(gym.getCeo().getCeoId());
        GymFacilities gymFacilities = gymFacilitiesRepository.findById(new GymFacilitiesId(gym.getGymName()))
                .orElseGet(null);
        if(Objects.nonNull(gymFacilities)){
            response.setShowerBoothCnt(gymFacilities.getShowerBoothCnt());
            response.setFittingRoom(gymFacilities.getFittingRoom());
            response.setClothes(gymFacilities.getClothes());
            response.setLockerCnt(gymFacilities.getLockerCnt());
            response.setHowToAttendance(gymFacilities.getHowToAttendance());
        }

        List<GymMappingEE> byGym = gymMappingEERepository.findByGym(gym);
        for (GymMappingEE gymMappingEE : byGym) {
            ExerciseEquipment exerciseEquipment = getExerciseEquipment(gymMappingEE);
            ExerciseEquipmentDto ee = new ExerciseEquipmentDto();
            ee.setEquipmentName(exerciseEquipment.getEquipmentName());
            ee.setExercisePart(exerciseEquipment.getExercisePart());
            response.getExerciseEquipments().add(ee);

            List<EEMappingES> equipmentSupplement = eeMappingESRepository.findByExerciseEquipment(exerciseEquipment);

            for (EEMappingES eeMappingES : equipmentSupplement) {
                ee.getExerciseSupplements().add(
                        getExerciseSupplementDto(eeMappingES)
                );
            }

        }
        response.getTrainers().addAll(
            trainerRepository.findByGymName(gym)
                    .stream()
                    .map(TrainerBriefResponseDto::new)
                    .collect(Collectors.toList())
        );

        response.getEvents().addAll(
            eventRepository.findByEventDateTimeAfterAndGym(LocalDateTime.now(), gym)
                    .stream()
                    .map(EventDto::new)
                    .collect(Collectors.toList())
        );

        return response;
    }

    private ExerciseSupplementDto getExerciseSupplementDto(EEMappingES eeMappingES) {
        ExerciseSupplementDto es = new ExerciseSupplementDto();
        ExerciseSupplement exerciseSupplement = getExerciseSupplement(eeMappingES);
        es.setSupplementName(exerciseSupplement.getSupplementName());
        es.setUsePurpose(exerciseSupplement.getUsePurpose());
        return es;
    }

    private ExerciseEquipment getExerciseEquipment(GymMappingEE gymMappingEE) {
        return exerciseEquipmentRepository.findById(
                gymMappingEE.getExerciseEquipment().getEquipmentName()).orElseGet(null);
    }

    private ExerciseSupplement getExerciseSupplement(EEMappingES eeMappingES) {
        return exerciseSupplementRepository.findById(
                eeMappingES.getExerciseSupplement().getSupplementName()
        ).orElseGet(null);
    }

    private List<Gym> findAll(){
        return gymRepository.findAll();
    }
}
