package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.service.ClientAdditionalInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/additionalInfo")
public class ClientAdditionalInfoController extends BaseController<ClientAdditionalInfo, ClientAdditionalInfoService> {
    public ClientAdditionalInfoController(ClientAdditionalInfoService service) {
        super(service);
    }
}
