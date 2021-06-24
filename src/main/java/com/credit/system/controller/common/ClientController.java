package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.Client;
import com.credit.system.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client")
public class ClientController extends BaseController<Client, ClientService> {

    public ClientController(ClientService service) {
        super(service);
    }
}
