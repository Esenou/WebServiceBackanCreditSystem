package com.credit.system.service;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientCardInfo;
import com.credit.system.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientCardInfoService extends BaseService<ClientCardInfo> {
    Page<ClientCardInfo> findByAccount(Pageable pageable, String bankAccount);

    Page<ClientCardInfo> findByClientId(Pageable pageable, long id);

    Page<ClientCardInfo> findAllBy(Pageable pageable);
}
