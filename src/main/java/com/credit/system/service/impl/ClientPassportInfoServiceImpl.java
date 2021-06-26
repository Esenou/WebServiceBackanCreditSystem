package com.credit.system.service.impl;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientPassportInfo;
import com.credit.system.repo.ClientPassportInfoRepo;
import com.credit.system.repo.ClientRepo;
import com.credit.system.service.ClientPassportInfoService;
import com.credit.system.service.ClientService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientPassportInfoServiceImpl extends BaseServiceImpl<ClientPassportInfo, ClientPassportInfoRepo> implements ClientPassportInfoService {
    private final ClientPassportInfoRepo clientPassportInfoRepo;
    public ClientPassportInfoServiceImpl(ClientPassportInfoRepo clientPassportInfoRepo) {
        super(clientPassportInfoRepo);
        this.clientPassportInfoRepo = clientPassportInfoRepo;
    }

}
