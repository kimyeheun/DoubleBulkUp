package com.doubleBulkUp.User.service;

//@Component
//public class UserValidator implements Validator {
//
//    private final PersonRepository personRepository;
//
//    public UserValidator(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return UserLoginDto.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        UserLoginDto userLoginDto = (UserLoginDto) target;
//        if(personRepository.existsPersonByPersonId(userLoginDto.getUserId()))
//            errors.rejectValue("username", "key,", "이미 존재하는 아이디 입니다.");
//    }
//}
