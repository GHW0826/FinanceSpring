package com.finance.metadata;

import com.finance.metadata.AssetGroup.AssetGroupService;
import com.finance.metadata.AssetGroup.dto.GetAssetGroupRequest;
import com.finance.metadata.AssetGroup.dto.GetAssetGroupResponse;
import com.finance.metadata.InstrumentCategory.InstrumentCategoryService;
import com.finance.metadata.InstrumentCategory.dto.GetInstrumentCategoryRequest;
import com.finance.metadata.InstrumentCategory.dto.GetInstrumentCategoryResponse;
import com.finance.metadata.InstrumentGroup.InstrumentGroup;
import com.finance.metadata.InstrumentGroup.InstrumentGroupRepository;
import com.finance.metadata.InstrumentGroup.InstrumentGroupService;
import com.finance.metadata.InstrumentGroup.dto.GetInstrumentGroupRequest;
import com.finance.metadata.InstrumentGroup.dto.GetInstrumentGroupResponse;
import com.finance.metadata.PayyoffPattern.PayoffPatternService;
import com.finance.metadata.PayyoffPattern.dto.GetPayoffPatternRequest;
import com.finance.metadata.PayyoffPattern.dto.GetPayoffPatternResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metadata")
public class MetadataController {

    private final AssetGroupService assetGroupService;
    private final InstrumentGroupService instrumentGroupService;
    private final PayoffPatternService payoffPatternService;
    private final InstrumentCategoryService instrumentCategoryService;

    public MetadataController(
            AssetGroupService assetGroupService,
            InstrumentGroupService instrumentGroupService,
            PayoffPatternService payoffPatternService,
            InstrumentCategoryService instrumentCategoryService) {
        this.assetGroupService = assetGroupService;
        this.instrumentGroupService = instrumentGroupService;
        this.payoffPatternService = payoffPatternService;
        this.instrumentCategoryService = instrumentCategoryService;
    }

    @GetMapping("/asset-group")
    public List<GetAssetGroupResponse> GetAllAssetGroup(GetAssetGroupRequest req) {
        return assetGroupService.GetAllAssetGroup(req);
    }

    @GetMapping("/instrument-group")
    public List<GetInstrumentGroupResponse> GetAllInstrumentGroup(GetInstrumentGroupRequest req) {
        return instrumentGroupService.GetAllInstrumentGroup(req);
    }

    @GetMapping("/payoff-pattern")
    public List<GetPayoffPatternResponse> GetAllPayoffPattern(GetPayoffPatternRequest req) {
        return payoffPatternService.GetAllPayoffPattern(req);
    }

    @GetMapping("/instrument-category")
    public List<GetInstrumentCategoryResponse> GetAllInstCategory(GetInstrumentCategoryRequest req) {
        return instrumentCategoryService.GetAllInstCategory(req);
    }
}
