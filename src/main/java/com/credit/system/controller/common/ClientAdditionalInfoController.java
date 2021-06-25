package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.Client;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.enums.ListStatus;
import com.credit.system.enums.MaritalStatus;
import com.credit.system.repo.ClientAdditionalInfoRepo;
import com.credit.system.service.ClientAdditionalInfoService;
import com.credit.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client/additionalInfo")
public class ClientAdditionalInfoController extends BaseController<ClientAdditionalInfo, ClientAdditionalInfoService> {
    public ClientAdditionalInfoController(ClientAdditionalInfoService service) {
        super(service);
    }

    @Autowired
    private ClientAdditionalInfoService clientAdditionalInfoService;

    @Autowired
    private ClientService clientService;

    @GetMapping("{/creatAddInfo/{id}}")
    public String getClientById(@PathVariable("id") Long id, Model model){

        Client client = clientService.findById(id);
        ClientAdditionalInfo clientAdditionalInfo = new ClientAdditionalInfo();
        model.addAttribute("status", MaritalStatus.values());
        model.addAttribute("clientAdditionalInfo",clientAdditionalInfo);
        model.addAttribute("client", client);

        return "createAdditionalInfo";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, Model model, @ModelAttribute("clientAdInfo") ClientAdditionalInfo newInfo, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(newInfo);
        }
        ClientAdditionalInfo oldInfo =  clientAdditionalInfoService.findById(id);
        clientAdditionalInfoService.update(newInfo);
        return "redirect:/client/list";
    }

}
