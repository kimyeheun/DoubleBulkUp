package com.doubleBulkUp.user.controller;

import com.doubleBulkUp.user.dto.CeoSignupRequestDto;
import com.doubleBulkUp.user.dto.TrainerSignupRequestDto;
import com.doubleBulkUp.user.dto.UserLoginDto;
import com.doubleBulkUp.user.dto.UserSignupRequestDto;
import com.doubleBulkUp.user.entity.Gender;
import com.doubleBulkUp.user.entity.Purpose;
import com.doubleBulkUp.user.service.UserService;
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
    public String generalRegister(@ModelAttribute Gender gender, @ModelAttribute Purpose purpose, UserSignupRequestDto userSignupRequestDto) {
        userService.saveUser(gender, purpose, userSignupRequestDto);
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
