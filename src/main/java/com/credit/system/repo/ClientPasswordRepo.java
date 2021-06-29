package com.credit.system.repo;

import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.entity.ClientPasswordInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPasswordRepo extends BaseRepository<ClientPasswordInfo>{

//    Page<ClientPasswordInfo> findByClient_NameAndClient_Id(Long clientId, Pageable pageable, String username);
//
//    Page<ClientPasswordInfo> findByClient_Id(Long clientId, Pageable pageable);

    ClientPasswordInfo findByClientId(long id);
}
