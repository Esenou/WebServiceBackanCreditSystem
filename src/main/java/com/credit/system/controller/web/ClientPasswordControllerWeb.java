package com.credit.system.controller.web;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientPasswordInfo;
import com.credit.system.service.ClientPasswordService;
import com.credit.system.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("password")
public class ClientPasswordControllerWeb {

    private ClientPasswordService clientPasswordService;

    private ClientService clientService;

    public ClientPasswordControllerWeb(ClientPasswordService clientPasswordService, ClientService clientService) {
        this.clientPasswordService = clientPasswordService;
        this.clientService = clientService;
    }



    @GetMapping("{id}")
    public String getClientPasswordInfo(@PathVariable("id") long id, Model model){

        ClientPasswordInfo passwordInfo = clientPasswordService.findByClientId(id);
        model.addAttribute("client", clientService.findById(id));

        if(passwordInfo == null){
            model.addAttribute("add", true);
            model.addAttribute("passwordInfo", new ClientPasswordInfo());

        } else {
            model.addAttribute("add", false);
            model.addAttribute("passwordInfo", passwordInfo);
        }
        return "clientPasswordInfo";
    }


    @PostMapping("/update/{id}")
    public String updatePasswordInfo(@PathVariable("id") Long id
            , @ModelAttribute("passwordInfo") ClientPasswordInfo newInfo
    ) {
        ClientPasswordInfo oldInfo = clientPasswordService.findById(id);
        Client client = clientService.findById(oldInfo.getClient().getId());
        newInfo.setId(oldInfo.getId());
        newInfo.setCreateDate(oldInfo.getCreateDate());
        newInfo.setClient(client);
        clientPasswordService.update(newInfo);
        return "redirect:/client/" + client.getId();
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            clientPasswordService.deleteById(id);
        }catch (Exception e){

            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/client/" + clientPasswordService.findById(id).getClient().getId();
        }
        return "redirect:/client/" + clientPasswordService.findById(id).getClient().getId();
    }
}
