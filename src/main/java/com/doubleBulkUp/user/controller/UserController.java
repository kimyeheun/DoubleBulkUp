package com.doubleBulkUp.user.controller;

import com.doubleBulkUp.user.dto.CeoSignupRequestDto;
import com.doubleBulkUp.user.dto.TrainerSignupRequestDto;
import com.doubleBulkUp.user.dto.UserLoginDto;
import com.doubleBulkUp.user.dto.UserSignupRequestDto;
import com.doubleBulkUp.user.entity.Gender;
import com.doubleBulkUp.user.entity.Purpose;
import com.doubleBulkUp.user.entity.UserType;
import com.doubleBulkUp.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
    public String generalRegister(UserSignupRequestDto userSignupRequestDto) {
        if(userService.saveUserP(userSignupRequestDto)) {
            if(userService.saveUser(userSignupRequestDto)) {
                return "redirect:/user/" + userSignupRequestDto.getUserId();
            }
        }
        return "redirect:/";
    }

    @GetMapping("/trainer")
    public String trainerRegister(Model model){
        model.addAttribute("trainer", new TrainerSignupRequestDto());
        return "/user/SignUpT";
    }
    @PostMapping("/trainer")
    public String trainerRegister(TrainerSignupRequestDto trainerSignupRequestDto){
        userService.saveTrainer(trainerSignupRequestDto);
        return "redirect:/";
    }

    @GetMapping("/ceo")
    public String ceoRegister(Model model){
        model.addAttribute("ceo", new CeoSignupRequestDto());
        return "/user/SignUpO";
    }
    @PostMapping("/ceo")
    public String ceoRegister(@ModelAttribute Gender gender, CeoSignupRequestDto ceoSignupRequestDto) {
        userService.saveCeoP(ceoSignupRequestDto);
        return "redirect:/";
    }

    /**
     * 회원 삭제
     */
    @DeleteMapping("/{personId}")
    public String userDelete(@PathVariable String personId) {
        if(userService.deletePerson(personId))
            return "redirect:/";
        return "redirect:/user/" + personId;
    }


    /**
     * 마이페이지
     */
    @GetMapping("/{personId}")
    public String userDetail(Model model, @PathVariable String personId){
        UserType userType = userService.getUserType(personId);

        if(userType == UserType.CEO){
            model.addAttribute("ceo", userService.findCeoDetailDtoById(personId));
            return "user/MyCeoPage";
        } else if(userType == UserType.Trainer){
            model.addAttribute("trainer", userService.findTrainerDetailDtoById(personId));
            return "user/MyTrainerPage";
        } else if(userType == UserType.User){
            model.addAttribute("user", userService.findUserDetailDtoById(personId));
            return "user/MyPage";
        }

        return "index";
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
            System.out.println("this is user!!");
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
