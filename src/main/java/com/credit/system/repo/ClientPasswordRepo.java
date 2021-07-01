package com.credit.system.repo;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientPassword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPasswordRepo extends BaseRepository<ClientPassword>{

    ClientPassword findByClientId(long id);
}
