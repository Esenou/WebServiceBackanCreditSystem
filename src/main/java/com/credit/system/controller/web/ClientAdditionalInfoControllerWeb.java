package com.credit.system.controller.web;

import com.credit.system.controller.common.ClientAdditionalInfoController;
import com.credit.system.entity.Client;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.service.ClientAdditionalInfoService;
import com.credit.system.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("additionalInfo")
public class ClientAdditionalInfoControllerWeb {


    private final ClientAdditionalInfoService clientAdditionalInfoService;
    private final ClientService clientService;

    private static final Logger logger = LogManager.getLogger(ClientAdditionalInfoController.class);

    public ClientAdditionalInfoControllerWeb(ClientAdditionalInfoService clientAdditionalInfoService, ClientService clientService) {
        this.clientAdditionalInfoService = clientAdditionalInfoService;
        this.clientService = clientService;
    }


    @GetMapping("{id}")
    public String getClientAdditionalInfo(@PathVariable("id") Long id, Model model) {

        ClientAdditionalInfo clientAdditionalInfo = clientAdditionalInfoService.findByClientId(id);
        model.addAttribute("clientAdditionalInfo", clientAdditionalInfo);
        model.addAttribute("add", false);

        return "clientAdditionalInfoForm";
    }


    @PostMapping("/updateAddInfo/{id}")
    public String updateClientAddInfo(@PathVariable("id") Long id
            , @ModelAttribute("client") Client client, Model model
            , @ModelAttribute("clientAdditionalInfo") ClientAdditionalInfo newInfo,BindingResult result
    ) {

        ClientAdditionalInfo oldClientInfo = clientAdditionalInfoService.findById(id);
        if(result.hasErrors()){
            model.addAttribute("clientAdditionalInfo", oldClientInfo);
            model.addAttribute("add", false);
        }

        newInfo.setId(oldClientInfo.getId());
        newInfo.setCreateDate(oldClientInfo.getCreateDate());
        newInfo.setClient(client);
        clientAdditionalInfoService.update(newInfo);
        return "redirect:/client/" + client.getId();
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            clientService.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/client/" + id;
        }
        return "redirect:/client/list";
    }
}