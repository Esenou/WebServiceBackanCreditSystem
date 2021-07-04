package com.credit.system.repo;

import com.credit.system.entity.Client;
import com.credit.system.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends BaseRepository<Loan>{

    Page<Loan> findByClient_Name(Pageable pageable, String name);

    Page<Loan> findAllByOrderByCreateDateDesc(Pageable pageable);

}
