package com.doubleBulkUp.user.controller;

import com.doubleBulkUp.user.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trainer")
@AllArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    /**
     * 트레이너 리스트
     */
    @GetMapping
    public String trainerList(Model model){
        model.addAttribute("trainers", trainerService.findAll());
        return "trainer/trainerList";
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        System.out.println("keyword" + keyword);
        model.addAttribute("trainers", trainerService.search(keyword));
        return "trainer/trainerList";
    }

}