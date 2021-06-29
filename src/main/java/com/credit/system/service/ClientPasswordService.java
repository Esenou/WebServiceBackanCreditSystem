package com.credit.system.service;

import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.entity.ClientPasswordInfo;
import com.credit.system.service.base.BaseService;

public interface ClientPasswordService extends BaseService<ClientPasswordInfo> {

    ClientPasswordInfo findByClientId(long id);
}
