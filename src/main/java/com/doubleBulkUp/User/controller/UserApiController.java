package com.doubleBulkUp.User.controller;

import com.doubleBulkUp.User.dto.UserLoginDto;
import com.doubleBulkUp.User.dto.UserSignupRequestDto;
import com.doubleBulkUp.User.entity.Gender;
import com.doubleBulkUp.User.entity.Purpose;
import com.doubleBulkUp.User.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserApiController {

    private final UserService userService;

    @ModelAttribute("gender")
    public Gender[] genders() {
        return Gender.values();
    }

    @ModelAttribute("purpose")
    public Purpose[] purposes(){
        return Purpose.values();
    }


    /**
     * 회원가입 - 유저 유형 선택
     */
    @GetMapping
    public String chooseUser(){
        return "/user/selectType";
    }

    @GetMapping("/general")
    public String generalRegister(Model model){
        model.addAttribute("user", new UserSignupRequestDto());
        return "/user/SignUp";
    }


    @PostMapping("/general")
    public String userSignUp(@ModelAttribute Gender gender, UserSignupRequestDto userSignupRequestDto) {
        userService.saveUser(userSignupRequestDto);
        return "redirect:/";
    }

    @GetMapping("/trainer")
    public String trainerRegister(){
        return "/user/SignUpT";
    }

    @GetMapping("/ceo")
    public String ceoRegister(){
        return "/user/SignUpO";
    }

    /**
     * 로그인
     */
    @GetMapping("/login")
    public String userLogin() {
        return "/user/SignIn";
    }

    @PostMapping("/login")
    public String userLogin(UserLoginDto userLoginDto) {
        if(userService.login(userLoginDto))
            return "/user/selectType";
        return "redirect:/";
    }
}
