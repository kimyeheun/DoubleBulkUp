package com.doubleBulkUp.gym.controller;

import com.doubleBulkUp.gym.dto.EquipmentDto;
import com.doubleBulkUp.gym.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping("/{gymName}")
    public String equipmentSave(
            @PathVariable String gymName,
            Model model
    ){
        model.addAttribute("equipment", new EquipmentDto(gymName));
        return "equipment/equipment";
    }

    @PostMapping("/{gymName}")
    public String equipment(
            @PathVariable String gymName,
            EquipmentDto equipmentDto
    ) {
        System.out.println("hihhih");
        System.out.println(gymName);
        if(equipmentService.saveEquipment(gymName, equipmentDto))
            return "redirect:/gym/" + gymName;
        return "redirect:/gym";
    }
}
