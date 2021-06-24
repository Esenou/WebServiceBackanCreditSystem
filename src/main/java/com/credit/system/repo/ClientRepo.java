package com.credit.system.repo;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientPassword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends BaseRepository<Client>{

    Page<Client> findByNameOrderByCreateDateDesc(Pageable pageable, String username);

    Page<Client> findAllByOrderByCreateDateDesc(Pageable pageable);
}
