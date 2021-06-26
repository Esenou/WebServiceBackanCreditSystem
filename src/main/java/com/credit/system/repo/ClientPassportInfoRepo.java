package com.credit.system.repo;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientPassportInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPassportInfoRepo extends BaseRepository<ClientPassportInfo> {

}
