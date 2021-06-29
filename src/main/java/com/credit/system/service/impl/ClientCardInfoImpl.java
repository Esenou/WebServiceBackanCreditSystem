package com.credit.system.service.impl;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientCardInfo;
import com.credit.system.repo.ClientCardInfoRepo;
import com.credit.system.service.ClientCardInfoService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardInfoImpl extends BaseServiceImpl<ClientCardInfo, ClientCardInfoRepo> implements ClientCardInfoService {
    private ClientCardInfoRepo clientCardInfoRepo;
    public ClientCardInfoImpl(ClientCardInfoRepo clientCardInfoRepo) {
        super(clientCardInfoRepo);
        this.clientCardInfoRepo = clientCardInfoRepo;
    }

    @Override
    public Page<ClientCardInfo> findByAccount(Pageable pageable, String bankAccount) {
        return clientCardInfoRepo.findByBankAccountOrderByCreateDateDesc(pageable,bankAccount);
    }

    @Override
    public Page<ClientCardInfo> findByClientId(Pageable pageable, long id) {
        return clientCardInfoRepo.findByClientIdOrderByCreateDateDesc(pageable, id);
    }

    @Override
    public Page<ClientCardInfo> findAllBy(Pageable pageable) {
        return clientCardInfoRepo.findAllByOrderByCreateDateDesc(pageable);
    }
}
