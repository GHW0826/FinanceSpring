package com.finance.common.common.service;

import com.finance.common.common.dto.GetInstrumentGroupRequest;
import com.finance.common.common.dto.GetInstrumentGroupResponse;
import com.finance.common.common.entity.InstrumentGroup;
import com.finance.common.common.repository.InstrumentGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InstrumentGroupService {
    private final InstrumentGroupRepository instrumentGroupRepository;

    public InstrumentGroupService(InstrumentGroupRepository instrumentGroupRepository) {
        this.instrumentGroupRepository = instrumentGroupRepository;
    }

    public List<GetInstrumentGroupResponse> GetAllInstrumentGroup(GetInstrumentGroupRequest req) {
        List<InstrumentGroup> instGrp = instrumentGroupRepository.findAll();
        return instGrp.stream()
                .map(ag -> new GetInstrumentGroupResponse(ag.getCode(), ag.getName()))
                .toList();
    }
}