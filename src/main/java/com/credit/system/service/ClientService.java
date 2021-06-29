package com.credit.system.service;

import com.credit.system.entity.Client;
import com.credit.system.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService extends BaseService<Client> {
    Page<Client> findByName(Pageable pageable, String username);

    Page<Client> findAllBy(Pageable pageable);
}
