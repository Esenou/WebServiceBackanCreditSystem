package com.credit.system.controller.web;

import com.credit.system.entity.Client;
import com.credit.system.service.ClientPasswordService;
import com.credit.system.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("passwordInfo")
public class ClientPasswordControllerWeb {

    private ClientPasswordService clientPasswordService;

    private ClientService clientService;

    public ClientPasswordControllerWeb(ClientPasswordService clientPasswordService, ClientService clientService) {
        this.clientPasswordService = clientPasswordService;
        this.clientService = clientService;
    }



    @GetMapping("{id}")
    private String getClientPasswordInfo(@PathVariable("id") long id, Model model){



        return null;
    }
}
