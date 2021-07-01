package com.credit.system.service;

import com.credit.system.entity.ClientCardInfo;
import com.credit.system.service.base.BaseService;

public interface ClientCardInfoService extends BaseService<ClientCardInfo> {
    ClientCardInfo findByClientId(Long id);
}
