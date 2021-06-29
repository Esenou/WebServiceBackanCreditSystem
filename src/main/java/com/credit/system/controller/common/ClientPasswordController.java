package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.ClientPasswordInfo;
import com.credit.system.service.ClientPasswordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/password")
public class ClientPasswordController extends BaseController<ClientPasswordInfo, ClientPasswordService> {
    public ClientPasswordController(ClientPasswordService service) {
        super(service);
    }
}
