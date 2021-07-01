package com.credit.system.controller.web;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientCardInfo;
import com.credit.system.entity.ClientPassword;
import com.credit.system.service.ClientCardInfoService;
import com.credit.system.service.ClientPasswordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clientPassword")
public class ClientPasswordControllerWeb {

    private final ClientPasswordService clientPasswordService;

    private static final Logger logger = LogManager.getLogger(ClientPasswordControllerWeb.class);

    public ClientPasswordControllerWeb(ClientPasswordService clientPasswordService) {
        this.clientPasswordService = clientPasswordService;
    }

    @GetMapping("{id}")
    public String getClientCardInfo(@PathVariable("id") Long id, Model model) {

        ClientPassword clientPassword = clientPasswordService.findByClientId(id);

        if(clientPassword == null){
            return "redirect:/client/" + id;
        }
        model.addAttribute("clientPassword", clientPassword);
        model.addAttribute("add", false);

        return "clientPasswordForm";
    }


    @PostMapping("/updateClientPassword/{id}")
    public String updateClientAddInfo(@PathVariable("id") Long id
            , @ModelAttribute("client") Client client, Model model
            , @ModelAttribute("clientPassword") ClientPassword clientPassword, BindingResult result
    ) {

        ClientPassword oldClientPassword = clientPasswordService.findById(id);

        if(result.hasErrors()){
            model.addAttribute("clientPassword", oldClientPassword);
            model.addAttribute("add", false);
        }

        clientPassword.setId(id);
        clientPassword.setClient(client);
        clientPasswordService.update(clientPassword);
        return "redirect:/client/" + client.getId();
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            clientPasswordService.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/client/" + id;
        }
        return "redirect:/client/list";
    }
}
