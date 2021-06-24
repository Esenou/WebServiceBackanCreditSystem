package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.ClientImage;
import com.credit.system.service.ClientImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/image")
public class ClientImageController extends BaseController<ClientImage, ClientImageService> {
    public ClientImageController(ClientImageService service) {
        super(service);
    }
}
