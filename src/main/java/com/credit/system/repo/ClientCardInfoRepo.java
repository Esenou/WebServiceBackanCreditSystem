package com.credit.system.repo;

import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.entity.ClientCardInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCardInfoRepo extends BaseRepository<ClientCardInfo>{
    ClientCardInfo findByClientId(Long id);
}
