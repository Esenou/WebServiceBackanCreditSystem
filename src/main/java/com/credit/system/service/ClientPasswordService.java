package com.credit.system.service;

import com.credit.system.entity.ClientPassword;
import com.credit.system.service.base.BaseService;

public interface ClientPasswordService extends BaseService<ClientPassword> {
    ClientPassword findByClientId(long id);
}
