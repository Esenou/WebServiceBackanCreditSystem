package com.credit.system.controller.web;


import com.credit.system.entity.Client;
import com.credit.system.entity.ClientCardInfo;
import com.credit.system.entity.Loan;
import com.credit.system.entity.User;
import com.credit.system.enums.ListStatus;
import com.credit.system.enums.LoanStatus;
import com.credit.system.service.ClientCardInfoService;
import com.credit.system.service.LoanService;
import com.credit.system.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/loan")
public class LoanControllerWeb {

    private final LoanService loanService;

    private final UserService userService;

    private User user;

    public LoanControllerWeb(LoanService loanService, UserService user) {
        this.loanService = loanService;
        this.userService = user;
    }

    private static final Logger logger = LogManager.getLogger(ClientCardInfoControllerWeb.class);


    @GetMapping("/list")
    public String getList(@PageableDefault(5) Pageable pageable,
                                @RequestParam(value = "search", required = false) String username, Model model){
        Page<Loan> loans;
        if(username != null){
            loans = loanService.findByClient_NameAndOrderByCreateDateDesc(pageable,username);
        } else {
            loans = loanService.findAllByOrderByCreateDateDesc(pageable);
        }
        model.addAttribute("loanList",loans);
        return "loanList";
    }



    @GetMapping("{id}")
    public String getById(@PathVariable("id") Long id, Model model) {

        Loan loan = loanService.findById(id);

        if(loan == null){
            return "redirect:/loan/" + id;
        }
        model.addAttribute("loan", loan);
        model.addAttribute("add", false);
        model.addAttribute("status", LoanStatus.values());
        model.addAttribute("user",loadUser(1L));

        return "loanForm";
    }


    @PostMapping("/update/{id}")
    public String updateClientAddInfo(@PathVariable("id") Long id
            , @ModelAttribute("loan") Loan loan, Model model, BindingResult result
    ) {
        Loan oldLoan = loanService.findById(id);
        if(result.hasErrors()){
            model.addAttribute("loan", oldLoan);
            model.addAttribute("add", false);
        }
        loanService.updateStatus(loan.getUser().getId(),loan.getId(),loan.getStatus());
        loan.setId(id);
        loanService.update(loan);
        return "redirect:/loan/list";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            loanService.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/loan/" + id;
        }
        return "redirect:/loan/list";
    }

    private User loadUser(Long id) {
        return user == null ? userService.findById(id) : new User();
    }
}
