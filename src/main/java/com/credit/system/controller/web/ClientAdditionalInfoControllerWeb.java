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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




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




    @PostMapping("{/create/{id}")
    public String addInfo(@PathVariable("id") Long id, Model model,  @ModelAttribute("clientAdditionalInfo") ClientAdditionalInfo newInfo, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(newInfo);
        }

        newInfo.setClient(clientService.findById(id));
        clientAdditionalInfoService.create(newInfo);
        return "redirred:/{id}";
    }


    @GetMapping("{id}")
    public String AdditionalInfo(@PathVariable("id") Long id, Model model){


        Client client = clientService.findById(id);
        ClientAdditionalInfo clientAdditionalInfo = clientAdditionalInfoService.findByClientId(id);


        if(clientAdditionalInfo == null){
            model.addAttribute("maritalStatus", MaritalStatus.values());
            model.addAttribute("client", client);
            model.addAttribute("clientAdditionalInfo",new ClientAdditionalInfo());
            model.addAttribute("add",true);
        } else {
            model.addAttribute("maritalStatus", MaritalStatus.values());
            model.addAttribute("client", client);
            model.addAttribute("clientAdditionalInfo",clientAdditionalInfo);
            model.addAttribute("add",false);
        }


        return "clientAdditionalInfo";
    }




    @PostMapping("/updateAddInfo/{id}")
    public String updateClientAddInfo(@PathVariable("id") Long id
            ,@ModelAttribute("client") Client client
            , @ModelAttribute("clientAdditionalInfo") ClientAdditionalInfo newInfo
           ) {
        ClientAdditionalInfo oldClientInfo = clientAdditionalInfoService.findById(id);
        newInfo.setId(oldClientInfo.getId());
        newInfo.setCreateDate(oldClientInfo.getCreateDate());
        newInfo.setClient(client);
        clientAdditionalInfoService.update(newInfo);
        return "redirect:/client/" + client.getId();
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


}