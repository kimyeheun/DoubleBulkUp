package com.doubleBulkUp.User.service;

import com.doubleBulkUp.User.dto.UserLoginDto;
import com.doubleBulkUp.User.dto.UserSignupRequestDto;
import com.doubleBulkUp.User.entity.Person;
import com.doubleBulkUp.User.entity.User;
import com.doubleBulkUp.User.entity.UserType;
import com.doubleBulkUp.User.repository.PersonRepository;
import com.doubleBulkUp.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    /**
     * 사용 가능하면 true
     * 사용 불가하면 false
     */
    public boolean usernameValid(String username) {
        return !personRepository.existsPersonByPersonId(username);
    }

    public void saveUser(UserSignupRequestDto userSignupRequestDto) {
        User user = new User();
        user.setPersonId(userSignupRequestDto.getUserId());
        user.setUserPassword(userSignupRequestDto.getPassword());
        user.setUserName(userSignupRequestDto.getUserName());
//        user.setGender(userSignupRequestDto.getGender());
        user.setUserEmail(userSignupRequestDto.getUserEmail());
        user.setUserBirth(userSignupRequestDto.getUserBirth());
        user.setUserPhone(userSignupRequestDto.getUserPhone());

        user.setUserAddress(userSignupRequestDto.getUserAddress());
        user.setUserHeight(userSignupRequestDto.getUserHeight());
        user.setUserWeight(userSignupRequestDto.getUserWeight());

        user.setUserType(UserType.valueOf("User"));
        userRepository.save(user);
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<Person> person = personRepository.findByPersonId(userLoginDto.getUserId());
        if(person.isEmpty())
            return false;
        Person p = person.get();
        return p.getUserPassword().equals(userLoginDto.getPassword());
    }
}
