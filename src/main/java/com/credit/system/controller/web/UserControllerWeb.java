package com.credit.system.controller.web;

import com.credit.system.entity.Client;
import com.credit.system.entity.LoanPercent;
import com.credit.system.entity.User;
import com.credit.system.enums.ListStatus;
import com.credit.system.enums.Roles;
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

    private final UserService userService;

    public UserControllerWeb(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("status",ListStatus.values());
        model.addAttribute("roles", Roles.values());
        return "userList";
    }


    @GetMapping("/form")
    public String getForm(Model model){
        /*List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);*/
        model.addAttribute("add", true);
        model.addAttribute("user", new User());
        model.addAttribute("status",ListStatus.values());
        model.addAttribute("roles", Roles.values());
        return "userForm";
    }

    @GetMapping("{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("add",false);
        model.addAttribute("user",user);
        model.addAttribute("status",ListStatus.values());
        model.addAttribute("roles", Roles.values());
        return "userForm";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            userService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/user/" + id;
        }
        return "redirect:/user/list";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model, @ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(user);
        }
        user.setId(id);
        userService.update(user);
        return "redirect:/user/list";
    }



    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user,
                         BindingResult result, Model model){
//        if (result.hasErrors()) {
//            model.addAttribute(category);
//            model.addAttribute("add", true);
//            return "orgCategoryForm";
//        }
        userService.create(user);
        return "redirect:/user/list";
    }





}
