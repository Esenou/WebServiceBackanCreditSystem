package com.credit.system.service.impl;

import com.credit.system.entity.User;
import com.credit.system.repo.UserRepo;
import com.credit.system.service.UserService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepo> implements UserService {
    public UserServiceImpl(UserRepo userRepo) {
        super(userRepo);
    }
}
