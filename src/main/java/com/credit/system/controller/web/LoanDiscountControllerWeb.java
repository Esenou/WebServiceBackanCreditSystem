package com.credit.system.controller.web;

import com.credit.system.entity.LoanDiscount;
import com.credit.system.entity.LoanPercent;
import com.credit.system.service.LoanDiscountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("loanDiscount")
public class LoanDiscountControllerWeb {

    private LoanDiscountService loanDiscountService;

    public LoanDiscountControllerWeb(LoanDiscountService loanDiscountService) {
        this.loanDiscountService = loanDiscountService;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("loanDiscount") LoanDiscount loanDiscount,
                         BindingResult result, Model model){
       /* if (result.hasErrors()) {
            model.addAttribute(category);
            model.addAttribute("add", true);
            return "orgCategoryForm";
        }*/
        loanDiscountService.create(loanDiscount);
        return "redirect:/loanDiscount/list";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<LoanDiscount> loanDiscount = loanDiscountService.findAll();
        model.addAttribute("loanDiscount", loanDiscount);
        return "loanDiscountList";
    }


    @GetMapping("/form")
    public String getForm(Model model){
        List<LoanDiscount> loanDiscount = loanDiscountService.findAll();
        model.addAttribute("loanDiscount", loanDiscount);
        model.addAttribute("add", true);
        model.addAttribute("loanDiscount", new LoanDiscount());
        return "loanDiscountForm";
    }

    @GetMapping("{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        LoanDiscount loanDiscount = loanDiscountService.findById(id);
        model.addAttribute("add",false);
        model.addAttribute("loanDiscount",loanDiscount);
        return "loanDiscountForm";
    }


    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            loanDiscountService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/loanDiscount/" + id;
        }
        return "redirect:/loanDiscount/list";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model, @ModelAttribute("loanDiscount") LoanDiscount loanDiscount, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(loanDiscount);
        }
        loanDiscount.setId(id);
        loanDiscountService.update(loanDiscount);
        return "redirect:/loanDiscount/list";
    }

}
