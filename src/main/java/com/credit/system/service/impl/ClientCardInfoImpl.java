package com.credit.system.service.impl;

import com.credit.system.entity.ClientCardInfo;
import com.credit.system.repo.ClientCardInfoRepo;
import com.credit.system.service.ClientCardInfoService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientCardInfoImpl extends BaseServiceImpl<ClientCardInfo, ClientCardInfoRepo> implements ClientCardInfoService {
    public ClientCardInfoImpl(ClientCardInfoRepo clientCardInfoRepo) {
        super(clientCardInfoRepo);
    }
}
