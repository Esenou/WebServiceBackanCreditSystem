package com.credit.system.controller.web;

import com.credit.system.entity.Penalty;
import com.credit.system.service.PenaltyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("penalty")
public class PenaltyControllerWeb {

    private PenaltyService penaltyService;

    public PenaltyControllerWeb(PenaltyService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @PostMapping("/create")
    public String create(Penalty penalty, Model model, BindingResult result){

        if(result.hasErrors()){
            model.addAttribute("has_exception", result);
        }

        penaltyService.create(penalty);
        return "redirect:/penalty/list";
    }


    @GetMapping("/list")
    public String getList(Model model){
        List<Penalty> penalties = penaltyService.findAll();
        model.addAttribute("penalties", penalties);
        model.addAttribute("add", false);
        return "penaltyList";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable("id") Long id, Model model){

        Penalty penalty = penaltyService.findById(id);
        model.addAttribute("add", false);
        model.addAttribute("penalty", penalty);

        return "penaltyForm";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("penalty") Penalty penalty,  Model model, BindingResult
            result){
        if(result.hasErrors()){
            model.addAttribute("has_exception", result);
            model.addAttribute(penalty);
        }
        penalty.setId(id);
        penalty.setCreateDate(penaltyService.findById(id).getCreateDate());
        penaltyService.update(penalty);
        return "redirect:/penalty/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            penaltyService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/penalty/" + id;
        }
        return "redirect:/penalty/list";
    }

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("penalty", new Penalty());
        model.addAttribute("add", true);
        return "penaltyForm";
    }


}
