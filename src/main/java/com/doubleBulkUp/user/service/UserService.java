package com.doubleBulkUp.user.service;

import com.doubleBulkUp.user.dto.CeoSignupRequestDto;
import com.doubleBulkUp.user.dto.TrainerSignupRequestDto;
import com.doubleBulkUp.user.dto.UserLoginDto;
import com.doubleBulkUp.user.dto.UserSignupRequestDto;
import com.doubleBulkUp.user.entity.*;
import com.doubleBulkUp.user.repository.CeoRepository;
import com.doubleBulkUp.user.repository.PersonRepository;
import com.doubleBulkUp.user.repository.TrainerRepository;
import com.doubleBulkUp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final CeoRepository ceoRepository;
    private final TrainerRepository trainerRepository;

    /**
     * 사용 가능하면 true
     * 사용 불가하면 false
     */
    public boolean usernameValid(String username) {
        return !personRepository.existsPersonByPersonId(username);
    }

    public void saveUser(Gender gender, Purpose purpose, UserSignupRequestDto userSignupRequestDto) {
        User user = new User();
        user.setPersonId(userSignupRequestDto.getUserId());
        user.setUserPassword(userSignupRequestDto.getPassword());
        user.setUserName(userSignupRequestDto.getUserName());
        user.setGender(gender);
        user.setUserEmail(userSignupRequestDto.getUserEmail());
        user.setUserBirth(userSignupRequestDto.getUserBirth());
        user.setUserPhone(userSignupRequestDto.getUserPhone());

        user.setPurpose(purpose);
        user.setUserAddress(userSignupRequestDto.getUserAddress());
        user.setUserHeight(userSignupRequestDto.getUserHeight());
        user.setUserWeight(userSignupRequestDto.getUserWeight());

        user.setUserSignUpTime(LocalDateTime.now());
        user.setUserType(UserType.valueOf("User"));
        userRepository.save(user);
    }

    public void saveTrainer(Gender gender, TrainerSignupRequestDto trainerSignupRequestDto) {
        Trainer trainer = new Trainer();
        trainer.setPersonId(trainerSignupRequestDto.getTrainerId());
        trainer.setUserPassword(trainerSignupRequestDto.getPassword());
        trainer.setUserName(trainerSignupRequestDto.getTrainerName());
        trainer.setGender(trainerSignupRequestDto.getGender());
        trainer.setUserEmail(trainerSignupRequestDto.getTrainerEmail());
        trainer.setUserBirth(trainerSignupRequestDto.getTrainerBirth());
        trainer.setUserPhone(trainerSignupRequestDto.getTrainerPhone());

        trainer.setUserSignUpTime(LocalDateTime.now());
        trainer.setUserType(UserType.valueOf("Trainer"));
        trainerRepository.save(trainer);
    }

    public void saveCeo(Gender gender, CeoSignupRequestDto ceoSignupRequestDto) {
        Ceo ceo = new Ceo();
        ceo.setPersonId(ceoSignupRequestDto.getCeoId());
        ceo.setUserPassword(ceoSignupRequestDto.getPassword());
        ceo.setUserName(ceoSignupRequestDto.getCeoName());
        ceo.setGender(ceoSignupRequestDto.getGender());
        ceo.setUserEmail(ceoSignupRequestDto.getCeoEmail());
        ceo.setUserBirth(ceoSignupRequestDto.getCeoBirth());
        ceo.setUserPhone(ceoSignupRequestDto.getCeoPhone());

        ceo.setUserSignUpTime(LocalDateTime.now());
        ceo.setUserType(UserType.valueOf("Ceo"));
        ceoRepository.save(ceo);
    }


    public boolean login(UserLoginDto userLoginDto) {
        Optional<Person> person = personRepository.findByPersonId(userLoginDto.getUserId());
        if(person.isEmpty())
            return false;
        Person p = person.get();
        return p.getUserPassword().equals(userLoginDto.getPassword());
    }

    public Person findByPersonId(String personId){
        return personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    // todo: 수정사항
    public Ceo findByCeoId(String personId) {
        return ceoRepository.findById(personId)
                .orElseThrow(()->new IllegalArgumentException());
    }
}
