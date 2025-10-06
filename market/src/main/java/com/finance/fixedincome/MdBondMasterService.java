package com.finance.fixedincome;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MdBondMasterService {
    private final MdBondMasterRepository mdBondMasterRepository;

    public MdBondMasterService(MdBondMasterRepository mdBondMasterRepository) {
        this.mdBondMasterRepository = mdBondMasterRepository;
    }

    public List<GetMarketBondResponse> getAllBonds() {
        List<MdBondMaster> bonds = mdBondMasterRepository.findAll();
        return new ArrayList<GetMarketBondResponse>();
    }

    public GetMarketBondResponse getBondByMdCd(String mdCd) {
        // mdCd 기준 단건 반환
        MdBondMaster bond = mdBondMasterRepository.findByMdCd(mdCd)
                .orElseThrow();
        // 예시용: return
        return new GetMarketBondResponse();
    }


    public CreateMarketBondResponse create(CreateMarketBondRequest dto) {
        MdBondMaster bond = new MdBondMaster(
                dto.mdCd(),
                dto.name(),
                dto.ccy(),
                dto.ccy2(),
                dto.time(),
                dto.assetGroup(),
                dto.mktdataGroup(),
                dto.mktdataSect(),
                dto.lastMktDate(),
                dto.freq(),
                dto.srcCd(),
                dto.impDiff(),
                dto.impTime(),
                dto.fileId()
        );
        mdBondMasterRepository.save(bond);
        return new CreateMarketBondResponse(
                bond.getMdCd(),
                bond.getName(),
                bond.getCcy(),
                bond.getCcy2(),
                bond.getTime(),
                bond.getAssetGroup(),
                bond.getMktdataGroup(),
                bond.getMktdataSect(),
                bond.getLastMktDate(),
                bond.getFreq(),
                bond.getSrcCd(),
                bond.getImpDiff(),
                bond.getImpTime(),
                bond.getFileId());
    }

    public DeleteMarketBondResponse delete(String mdCd) {
        mdBondMasterRepository.deleteById(mdCd);
        return new DeleteMarketBondResponse();
    }
}