package com.credit.system.repo;

import com.credit.system.entity.ClientAdditionalInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAdditionalInfoRepo extends BaseRepository<ClientAdditionalInfo> {
    ClientAdditionalInfo findByClientId(Long id);
}
