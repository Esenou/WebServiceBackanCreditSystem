package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.User;
import com.credit.system.repo.BaseRepository;
import com.credit.system.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/client/User")
public class UserRestController extends BaseController<User, UserService> {
    public UserRestController(UserService service) {
        super(service);
    }
}
