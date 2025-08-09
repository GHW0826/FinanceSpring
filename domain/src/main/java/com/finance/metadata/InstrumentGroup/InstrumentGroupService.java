package com.finance.metadata.InstrumentGroup;

import com.finance.metadata.AssetGroup.dto.GetAssetGroupResponse;
import com.finance.metadata.InstrumentGroup.dto.GetInstrumentGroupRequest;
import com.finance.metadata.InstrumentGroup.dto.GetInstrumentGroupResponse;
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