package com.finance.common.common.controller;

import com.finance.common.common.dto.GetAssetGroupRequest;
import com.finance.common.common.dto.GetAssetGroupResponse;
import com.finance.common.common.service.InstrumentCategoryService;
import com.finance.common.common.dto.GetInstrumentCategoryRequest;
import com.finance.common.common.dto.GetInstrumentCategoryResponse;
import com.finance.common.common.service.InstrumentGroupService;
import com.finance.common.common.dto.GetInstrumentGroupRequest;
import com.finance.common.common.dto.GetInstrumentGroupResponse;
import com.finance.common.common.service.PayoffPatternService;
import com.finance.common.common.dto.GetPayoffPatternRequest;
import com.finance.common.common.dto.GetPayoffPatternResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metadata")
public class MetadataController {

    private final InstrumentGroupService instrumentGroupService;
    private final PayoffPatternService payoffPatternService;
    //private final InstrumentCategoryService instrumentCategoryService;

    public MetadataController(
            InstrumentGroupService instrumentGroupService,
            PayoffPatternService payoffPatternService,
            InstrumentCategoryService instrumentCategoryService) {
        this.instrumentGroupService = instrumentGroupService;
        this.payoffPatternService = payoffPatternService;
       // this.instrumentCategoryService = instrumentCategoryService;
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
        return null;
    }
}
