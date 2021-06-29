package com.credit.system.repo;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.entity.ClientCardInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardInfoRepo extends BaseRepository<ClientCardInfo>{
    Page<ClientCardInfo> findByBankAccountOrderByCreateDateDesc(Pageable pageable, String bankAccount);
    Page<ClientCardInfo> findByClientIdOrderByCreateDateDesc(Pageable pageable, long id);
    Page<ClientCardInfo> findAllByOrderByCreateDateDesc(Pageable pageable);
}
