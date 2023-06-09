package com.doubleBulkUp.gym.controller;

import com.doubleBulkUp.gym.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
public class eventController {

    private final EventService eventService;

    @GetMapping
    public String eventList(
            Model model
    ){
        model.addAttribute("events", eventService.findEventListDto());
        return "event/eventList";
    }


}
