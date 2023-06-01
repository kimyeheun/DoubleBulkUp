package com.doubleBulkUp.user.service;

import com.doubleBulkUp.user.dto.*;
import com.doubleBulkUp.user.entity.*;
import com.doubleBulkUp.user.repository.CeoRepository;
import com.doubleBulkUp.user.repository.PersonRepository;
import com.doubleBulkUp.user.repository.TrainerRepository;
import com.doubleBulkUp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
        return !personRepository.existsPersonById(username);
    }

    /**
     * 회원가입
     */
    // todo:회원가입 person은 되는데 user가 안됨 -> null 값이라고 나옴
    public boolean saveUserP(Gender gender, UserSignupRequestDto userSignupRequestDto) {
        Person person = new Person();
        person.setId(userSignupRequestDto.getUserId());
        person.setUserPassword(userSignupRequestDto.getPassword());
        person.setUserName(userSignupRequestDto.getUserName());
        person.setGender(gender);
        person.setUserEmail(userSignupRequestDto.getUserEmail());
        person.setUserBirth(LocalDate.parse(userSignupRequestDto.getUserBirth()));
        person.setUserPhone(userSignupRequestDto.getUserPhone());

        person.setUserSignUpTime(LocalDateTime.now());
        person.setUserType(UserType.valueOf("User"));

        personRepository.save(person);
        return personRepository.existsPersonById(userSignupRequestDto.getUserId());
    }
    public boolean saveUser(Purpose purpose, UserSignupRequestDto userSignupRequestDto) {
        User user = new User();
        user.setUserId(userSignupRequestDto.getUserId());
        user.setPurpose(purpose);
        user.setUserAddress(userSignupRequestDto.getUserAddress());
        user.setUserHeight(userSignupRequestDto.getUserHeight());
        user.setUserWeight(userSignupRequestDto.getUserWeight());

        userRepository.save(user);
        return userRepository.existsByPersonId(userSignupRequestDto.getUserId());
    }

    public boolean saveTrainerP(Gender gender, TrainerSignupRequestDto trainerSignupRequestDto) {
        Person person = new Person();
        person.setId(trainerSignupRequestDto.getTrainerId());
        person.setUserPassword(trainerSignupRequestDto.getPassword());
        person.setUserName(trainerSignupRequestDto.getTrainerName());
        person.setGender(gender);
        person.setUserEmail(trainerSignupRequestDto.getTrainerEmail());
        person.setUserBirth(trainerSignupRequestDto.getTrainerBirth());
        person.setUserPhone(trainerSignupRequestDto.getTrainerPhone());

        person.setUserSignUpTime(LocalDateTime.now());
        person.setUserType(UserType.valueOf("Trainer"));

        personRepository.save(person);
        return personRepository.existsPersonById(trainerSignupRequestDto.getTrainerId());
    }
    public void saveTrainer(TrainerSignupRequestDto trainerSignupRequestDto) {

    }

    public boolean saveCeoP(Gender gender, CeoSignupRequestDto ceoSignupRequestDto) {
        Person person = new Person();
        person.setId(ceoSignupRequestDto.getCeoId());
        person.setUserPassword(ceoSignupRequestDto.getPassword());
        person.setUserName(ceoSignupRequestDto.getCeoName());
        person.setGender(gender);
        person.setUserEmail(ceoSignupRequestDto.getCeoEmail());
        person.setUserBirth(ceoSignupRequestDto.getCeoBirth());
        person.setUserPhone(ceoSignupRequestDto.getCeoPhone());

        person.setUserSignUpTime(LocalDateTime.now());
        person.setUserType(UserType.valueOf("Ceo"));

        personRepository.save(person);
        return personRepository.existsPersonById(ceoSignupRequestDto.getCeoId());
    }

    /**
     * 로그인
     */
    public UserType login(UserLoginDto userLoginDto) {
        Optional<Person> person = personRepository.findById(userLoginDto.getUserId());
        if(person.isEmpty())
            return null;
        Person p = person.get();
        if(!p.getUserPassword().equals(userLoginDto.getPassword()))
            return null;

        return p.getUserType();
    }

    /**
     * 아이디로 사람 찾기
     */
    public Person findByPersonId(String personId){
        return personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public User findByUserId(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public Trainer findTrainerByPersonId(String personId){
        return trainerRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public Ceo findCeoByPersonId(String personId){
        return ceoRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    /**
     *  general User 정보 - 마이페이지
     */
    public UserDetailResponseDto findUserDetailDtoById(String userId){
        Person person = findByPersonId(userId);
        User user = findByUserId(userId);

        UserDetailResponseDto response = new UserDetailResponseDto();
        response.setId(person.getId());
        response.setUserName(person.getUserName());
        response.setUserPhone(person.getUserPhone());
        response.setUserBirth(person.getUserBirth());
        response.setUserEmail(person.getUserEmail());
        response.setGender(person.getGender());
        response.setUserHeight(user.getUserHeight());
        response.setUserWeight(user.getUserWeight());
        response.setUserAddress(user.getUserAddress());

        //todo: 매핑 관계 - 선호
//        List<Gym> gyms = new ArrayList<>();

//        response.setGyms();

        return response;
    }

    /**
     *  Trainer 정보 - 마이페이지
     */
    public TrainerDetailResponseDto findTrainerDetailDtoById(String userId) {
        Person person = findByPersonId(userId);
        Trainer trainer = findTrainerByPersonId(userId);

        TrainerDetailResponseDto response = new TrainerDetailResponseDto();
        response.setId(userId);
        response.setUserName(person.getUserName());
        response.setUserBirth(person.getUserBirth());
        response.setUserEmail(person.getUserEmail());
        response.setUserPhone(person.getUserPhone());
        response.setGender(person.getGender());
        response.setGymName(trainer.getGymName().toString());
        response.setTrainerWorkTime(trainer.getTrainerWorkTime());

        //todo : 수상 경력, 자격증

        return response;
    }

    /**
     *  Ceo 정보 - 마이페이지
     */
    public CeoDetailResponseDto findCeoDetailDtoById(String userId){
        Person person = findByPersonId(userId);
        Ceo ceo = findCeoByPersonId(userId);

        CeoDetailResponseDto response = new CeoDetailResponseDto();
        response.setId(userId);
        response.setUserName(person.getUserName());
        response.setUserBirth(person.getUserBirth());
        response.setUserEmail(person.getUserEmail());
        response.setUserPhone(person.getUserPhone());
        response.setGender(person.getGender());

        //todo : 트레이너, 이벤트

        return response;
    }
}
