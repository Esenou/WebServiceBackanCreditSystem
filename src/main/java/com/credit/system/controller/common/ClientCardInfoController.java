package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.ClientCardInfo;
import com.credit.system.service.ClientCardInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/cardInfo")
public class ClientCardInfoController extends BaseController<ClientCardInfo, ClientCardInfoService> {
    public ClientCardInfoController(ClientCardInfoService service) {
        super(service);
    }
}
