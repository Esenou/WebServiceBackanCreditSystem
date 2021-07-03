package com.credit.system.controller.web;

import com.credit.system.entity.Client;
import com.credit.system.entity.LoanPercent;
import com.credit.system.entity.User;
import com.credit.system.enums.ListStatus;
import com.credit.system.service.LoanPercentService;
import com.credit.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControllerWeb {

  //  private final UserService userService;

   /* public UserControllerWeb(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);

        return "userList";
    }


    @GetMapping("/form")
    public String organizationForm(Model model){
        List<LoanPercent> loanPercent = loanPercentService.findAll();
        model.addAttribute("loanPercent", loanPercent);
        model.addAttribute("add", true);
        model.addAttribute("loanPercent", new LoanPercent());
        return "loanPercentForm";
    }
    @GetMapping("{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        LoanPercent loanPercent = loanPercentService.findById(id);
        model.addAttribute("add",false);
        model.addAttribute("loanPercent",loanPercent);
        return "loanPercentForm";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            loanPercentService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/loanPercent/" + id;
        }
        return "redirect:/loanPercent/list";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model, @ModelAttribute("loanPercent") LoanPercent loanPercent, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(loanPercent);
        }
        loanPercent.setId(id);
        loanPercentService.update(loanPercent);
        return "redirect:/loanPercent/list";
    }



    @PostMapping("/create")
    public String create(@ModelAttribute("loanPercent") LoanPercent loanPercent,
                         BindingResult result, Model model){
       *//* if (result.hasErrors()) {
            model.addAttribute(category);
            model.addAttribute("add", true);
            return "orgCategoryForm";
        }*//*
        loanPercentService.create(loanPercent);
        return "redirect:/loanPercent/list";
    }*/





}
