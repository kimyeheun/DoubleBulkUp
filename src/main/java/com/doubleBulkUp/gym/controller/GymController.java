package com.doubleBulkUp.gym.controller;

import com.doubleBulkUp.gym.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gym")
@RequiredArgsConstructor
public class GymController {
    private final GymService gymService;

    @GetMapping
    public String gymList(Model model){
        model.addAttribute("gyms", gymService.findAllGymDto());
        return "gym/gymList";
    }

    @GetMapping("/{gymId}")
    public String gym(
            @PathVariable String gymId,
            Model model
    ){
        model.addAttribute("gym", gymService.findGymDetailDtoById(gymId));
        return "gym/gymDetail";
    }
}
