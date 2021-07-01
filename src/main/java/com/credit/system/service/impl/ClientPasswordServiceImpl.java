package com.credit.system.service.impl;

import com.credit.system.entity.ClientPassword;
import com.credit.system.repo.ClientPasswordRepo;
import com.credit.system.service.ClientPasswordService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientPasswordServiceImpl extends BaseServiceImpl<ClientPassword, ClientPasswordRepo> implements ClientPasswordService {

    private  final ClientPasswordRepo clientPasswordRepo;

    public ClientPasswordServiceImpl(ClientPasswordRepo clientPasswordRepo) {
        super(clientPasswordRepo);
        this.clientPasswordRepo = clientPasswordRepo;
    }

    @Override
    public ClientPassword findByClientId(long id) {
        return clientPasswordRepo.findByClientId(id);
    }
}
