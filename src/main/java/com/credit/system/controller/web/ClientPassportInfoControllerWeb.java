package com.credit.system.controller.web;

import com.credit.system.entity.Client;
import com.credit.system.service.ClientPassportInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("passportInfo")
public class ClientPassportInfoControllerWeb {

    private final ClientPassportInfoService clientPassportInfoService;
    public ClientPassportInfoControllerWeb(ClientPassportInfoService clientPassportInfoService) {
        this.clientPassportInfoService = clientPassportInfoService;
    }

    @GetMapping("/test/{id}")
    public String getClientList(@PathVariable("id") Long id,
                                 String username, Model model){
        Page<Client> clients;
        System.out.println("--------------------===============================---------------------------------------------------");
//        logger.error("sfdsfdsfdsf "+username);
//        if(username != null){
//            clients = clientService.findByName(pageable,username);
//        } else {
//            clients = clientService.findAllBy(pageable);
//        }
//        model.addAttribute("clients",clients);
        return "clientAdditionalInfo";
    }
}
