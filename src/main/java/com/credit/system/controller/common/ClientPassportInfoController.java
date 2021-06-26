package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.ClientPassportInfo;
import com.credit.system.service.ClientPassportInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/passportInfo")
public class ClientPassportInfoController extends BaseController<ClientPassportInfo, ClientPassportInfoService> {
    public ClientPassportInfoController(ClientPassportInfoService service) {
        super(service);
    }
}
