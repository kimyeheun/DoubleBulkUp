package com.doubleBulkUp.gym.controller;

import com.doubleBulkUp.gym.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gym")
@RequiredArgsConstructor
public class GymController {
    private final GymService gymService;

    @GetMapping
    public String gymList(
            @RequestParam(name = "event", defaultValue = "false") Boolean event,
            Model model
    ){
        model.addAttribute("gyms", gymService.findGymListDto(event));
        return "gym/gymList";
    }

    /**
     * gym 검색 - 위치 기반
     */
    @GetMapping("/search")
    public String search(
            @RequestParam(value="location") String location, Model model
    ){
        model.addAttribute("gyms", gymService.search(location));
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
