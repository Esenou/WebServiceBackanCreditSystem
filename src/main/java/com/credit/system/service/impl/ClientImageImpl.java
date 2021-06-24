package com.credit.system.service.impl;

import com.credit.system.entity.ClientImage;
import com.credit.system.repo.ClientImageRepo;
import com.credit.system.service.ClientImageService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientImageImpl extends BaseServiceImpl<ClientImage, ClientImageRepo> implements ClientImageService{
    public ClientImageImpl(ClientImageRepo clientImageRepo) {
        super(clientImageRepo);
    }
}
