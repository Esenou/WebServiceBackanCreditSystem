package com.credit.system.controller.web;

import com.credit.system.entity.Budget;
import com.credit.system.service.BudgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/budget")
public class ClientBudgetControllerWeb {

    private final BudgetService budgetService;

    public ClientBudgetControllerWeb(BudgetService budgetService) {
        this.budgetService = budgetService;
    }




    @GetMapping("/form")
    public String getForm(Model model){
        List<Budget> budget = budgetService.findAll();
        model.addAttribute("budget", budget);
        model.addAttribute("add", true);
        model.addAttribute("loanPercent", new Budget());
        return "budgetForm";
    }
    @GetMapping("{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        Budget budget = budgetService.findById(id);
        model.addAttribute("add",false);
        model.addAttribute("budget",budget);
        return "budgetForm";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            budgetService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/budget/" + id;
        }
        return "redirect:/budget";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model, @ModelAttribute("budget") Budget budget, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(budget);
        }
        budget.setId(id);
        budgetService.update(budget);
        return "redirect:/budget";
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
        return "redirect:/budget";
    }
}
