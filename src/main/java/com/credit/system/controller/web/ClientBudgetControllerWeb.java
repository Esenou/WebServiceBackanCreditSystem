package com.credit.system.controller.web;

import com.credit.system.entity.*;
import com.credit.system.service.BudgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("budget")
public class ClientBudgetControllerWeb {

    private BudgetService budgetService;

    public ClientBudgetControllerWeb(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("{id}")
    public String getBudgetForm(@PathVariable("id") Long id, Model model) {

        try {
            Budget budget = budgetService.findById(id);
            model.addAttribute("budget", budget);
            model.addAttribute("add", false);
        } catch (RuntimeException e) {
            model.addAttribute("budget", new Budget());
            model.addAttribute("add", true);
            return "budgetForm";
        }
        return "budgetForm";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model, @ModelAttribute("budget") Budget budget, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(budget);
        }
        budget.setId(id);
        budgetService.update(budget);
        return "redirect:/budget/" + id;
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            budgetService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/budget/" + id;
        }

        return "redirect:/budget/"+ id;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("budget") Budget budget,
                         BindingResult result, Model model){
       /* if (result.hasErrors()) {
            model.addAttribute(category);
            model.addAttribute("add", true);
            return "orgCategoryForm";
        }*/
        budgetService.create(budget);
        return "redirect:/budget/" + budget.getId();
    }

}
