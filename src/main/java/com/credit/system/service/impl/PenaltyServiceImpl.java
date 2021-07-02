package com.credit.system.service.impl;

import com.credit.system.entity.Penalty;
import com.credit.system.repo.PenaltyRepo;
import com.credit.system.service.PenaltyService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PenaltyServiceImpl extends BaseServiceImpl<Penalty, PenaltyRepo> implements PenaltyService {
    public PenaltyServiceImpl(PenaltyRepo penaltyRepo) {
        super(penaltyRepo);
    }
}
