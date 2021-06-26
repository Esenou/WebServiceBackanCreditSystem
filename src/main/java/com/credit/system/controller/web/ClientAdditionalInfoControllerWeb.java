package com.credit.system.controller.web;

import com.credit.system.controller.common.ClientAdditionalInfoController;
import com.credit.system.entity.Client;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.enums.ListStatus;
import com.credit.system.enums.MaritalStatus;
import com.credit.system.service.ClientAdditionalInfoService;
import com.credit.system.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("additionalInfo")
public class ClientAdditionalInfoControllerWeb {

    private ClientAdditionalInfoService clientAdditionalInfoService;
    private ClientService clientService;
    private static final Logger logger = LogManager.getLogger(ClientAdditionalInfoController.class);
    public ClientAdditionalInfoControllerWeb(ClientAdditionalInfoService clientAdditionalInfoService, ClientService clientService) {
        this.clientAdditionalInfoService = clientAdditionalInfoService;
        this.clientService = clientService;
    }


    @GetMapping("{/creatAddInfo/{id}}")
    public String addInfo(@PathVariable("id") Long id, Model model){

        ClientAdditionalInfo clientAdditionalInfo = new ClientAdditionalInfo();
        model.addAttribute("status", ListStatus.values());
        model.addAttribute("clientAdditionalInfo",clientAdditionalInfo);

        return "createAdditionalInfo";
    }

    @GetMapping("{id}")
    public String AdditionalInfo(@PathVariable("id") Long id, Model model){

        Client client = clientService.findById(id);
        ClientAdditionalInfo clientAdditionalInfo = clientAdditionalInfoService.findById(id);
        model.addAttribute("status", MaritalStatus.values());
        model.addAttribute("client", client);
        model.addAttribute("clientAdditionalInfo",clientAdditionalInfo);
        model.addAttribute("add",true);
        return "clientAdditionalInfo";
    }


    @PostMapping("/updateAddInfo/{id}")
    public String updateClientAddInfo(@PathVariable("id") Long id, Model model, @ModelAttribute("clientAdInfo") ClientAdditionalInfo newInfo, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(newInfo);
        }
        ClientAdditionalInfo oldInfo =  clientAdditionalInfoService.findById(id);
        clientAdditionalInfoService.update(newInfo);
        return "redirect:/client/list";
    }
}
