package com.credit.system.service.impl;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.repo.ClientAdditionalInfoRepo;
import com.credit.system.service.ClientAdditionalInfoService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAdditionalInfoImpl extends BaseServiceImpl<ClientAdditionalInfo, ClientAdditionalInfoRepo> implements ClientAdditionalInfoService {

    private ClientAdditionalInfoRepo clientAdditionalInfoRepo;
    public ClientAdditionalInfoImpl(ClientAdditionalInfoRepo clientAdditionalInfoRepo) {
        super(clientAdditionalInfoRepo);
        this.clientAdditionalInfoRepo = clientAdditionalInfoRepo;
    }

    @Override
    public ClientAdditionalInfo findByClientId(long id) {
        return clientAdditionalInfoRepo.findByClientId(id);
    }
}
