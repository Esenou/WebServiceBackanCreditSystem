package com.credit.system.controller.web;

import com.credit.system.controller.HomeController;
import com.credit.system.entity.Client;
import com.credit.system.enums.ListStatus;
import com.credit.system.service.ClientService;
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

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("client")
public class ClientControllerWeb {
    private final ClientService clientService;
    private static final Logger logger = LogManager.getLogger(ClientControllerWeb.class);
    public ClientControllerWeb(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public String getClientList(@PageableDefault(5) Pageable pageable,
                                @RequestParam(value = "search", required = false) String username, Model model){
        Page<Client> clients;
        logger.error("sfdsfdsfdsf "+username);
        if(username != null){
            clients = clientService.findByName(pageable,username);
        } else {
            clients = clientService.findAllBy(pageable);
        }
        model.addAttribute("clients",clients);
        return "clientList";
    }

    @GetMapping("{id}")
    public String getClientById(@PathVariable("id") Long id, Model model){
        Client clientModel = clientService.findById(id);
        model.addAttribute("add",false);
        model.addAttribute("status", ListStatus.values());
        model.addAttribute("client",clientModel);
        return "clientForm";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            clientService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/client/" + id;
        }
        return "redirect:/client/list";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, Model model, @ModelAttribute("client") Client user, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(user);
        }
        Client user1 =  clientService.findById(id);
        user.setId(id);
        user.setCreateDate(user1.getCreateDate());
        user.setPassword(user1.getPassword());
        clientService.update(user);
        return "redirect:/client/list";
    }
}
