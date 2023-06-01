package com.doubleBulkUp.user.controller;

import com.doubleBulkUp.user.dto.*;
import com.doubleBulkUp.user.entity.Gender;
import com.doubleBulkUp.user.entity.Purpose;
import com.doubleBulkUp.user.entity.UserType;
import com.doubleBulkUp.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

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
    public String generalRegister(@ModelAttribute Gender gender, @ModelAttribute Purpose purpose, UserSignupRequestDto userSignupRequestDto) {
        if(userService.savePerson(gender, userSignupRequestDto) && userService.saveUser(purpose, userSignupRequestDto)) //성공하면
            return "redirect:/user/" + userSignupRequestDto.getUserId();
        return "redirect:/";
    }


    @GetMapping("/trainer")
    public String trainerRegister(Model model){
        model.addAttribute("trainer", new TrainerSignupRequestDto());
        return "/user/SignUpT";
    }
    @PostMapping("/trainer")
    public String trainerRegister(@ModelAttribute Gender gender, TrainerSignupRequestDto trainerSignupRequestDto){
        userService.saveTrainer(gender, trainerSignupRequestDto);
        return "redirect:/";
    }

    @GetMapping("/ceo")
    public String ceoRegister(Model model){
        model.addAttribute("ceo", new CeoSignupRequestDto());
        return "/user/SignUpO";
    }
    @PostMapping("/ceo")
    public String ceoRegister(@ModelAttribute Gender gender, CeoSignupRequestDto ceoSignupRequestDto) {
        userService.saveCeo(gender, ceoSignupRequestDto);
        return "redirect:/";
    }

    /**
     * 마이페이지
     */
    @GetMapping("/{personId}")
    public String myPage(
            @PathVariable String personId,
            Model model
    ) {
        model.addAttribute("user", userService.findUserDetailDtoById(personId));
        return "/user/MyPage";
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
        UserType userType = userService.login(userLoginDto);
        if(userType == UserType.User) {
            System.out.println("this is good!!");
            return "redirect:/user/" + userLoginDto.getUserId();
        }
        else if(userType == UserType.Trainer) {
            System.out.println("this is trainer");
            return "redirect:/user/" + userLoginDto.getUserId();
        }
        else if(userType == UserType.CEO) {
            System.out.println("this is ceo");
            return "redirect:/user/" + userLoginDto.getUserId();
        }
        return "redirect:/user/login";
    }
}
