package com.credit.system.service.impl;

import com.credit.system.entity.Client;
import com.credit.system.repo.ClientRepo;
import com.credit.system.service.ClientService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, ClientRepo> implements ClientService {

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        super(clientRepo);
        this.clientRepo = clientRepo;
    }

    @Override
    public Page<Client> findByName(Pageable pageable, String username) {
        return clientRepo.findByNameOrderByCreateDateDesc(pageable,username);
    }

    @Override
    public Page<Client> findAllBy(Pageable pageable) {
        return clientRepo.findAllByOrderByCreateDateDesc(pageable);
    }
}
