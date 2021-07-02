package com.credit.system.service.impl;

import com.credit.system.entity.PenaltyOperation;
import com.credit.system.repo.PenaltyOperationRepo;
import com.credit.system.service.PenaltyOperationService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PenaltyOperationServiceImpl extends BaseServiceImpl<PenaltyOperation, PenaltyOperationRepo> implements PenaltyOperationService {
    public PenaltyOperationServiceImpl(PenaltyOperationRepo penaltyOperationRepo) {
        super(penaltyOperationRepo);
    }
}
