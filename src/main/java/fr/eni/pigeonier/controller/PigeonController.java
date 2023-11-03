package fr.eni.pigeonier.controller;

import fr.eni.pigeonier.bll.PigeonService;
import fr.eni.pigeonier.bo.Pigeon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PigeonController {

    @Autowired
    private PigeonService pigeonService;

    @GetMapping("/pigeons")
    public String getAllPigeons(Model model) {
        List<Pigeon> pigeons = pigeonService.getAllPigeons();
        model.addAttribute("pigeons", pigeons);
        return "pigeon_list";
    }

    @GetMapping("/pigeons/add")
    public String showAddPigeonForm(Model model) {
        model.addAttribute("pigeon", new Pigeon());
        return "add_pigeon";
    }

    @GetMapping("/attaque")
    public String showAttaquePigeonnierPage(Model model) {
        return "attaque";
    }

    @PostMapping("/pigeons/add")
    public String addPigeon(@ModelAttribute("pigeon") Pigeon pigeon) {
        pigeonService.addPigeon(pigeon);
        return "redirect:/pigeons";
    }
}
