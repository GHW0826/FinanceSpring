package com.finance.metadata.AssetGroup;

import com.finance.metadata.AssetGroup.dto.GetAssetGroupRequest;
import com.finance.metadata.AssetGroup.dto.GetAssetGroupResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssetGroupService {
    private final AssetGroupRepository assetGroupRepository;

    public AssetGroupService(AssetGroupRepository assetGroupRepository) {
        this.assetGroupRepository = assetGroupRepository;
    }

    public List<GetAssetGroupResponse> GetAllAssetGroup(GetAssetGroupRequest req) {
        List<AssetGroup> assetGroups = assetGroupRepository.findAll();
        return assetGroups.stream()
                .map(ag -> new GetAssetGroupResponse(ag.getCode(), ag.getName()))
                .toList();
    }
}