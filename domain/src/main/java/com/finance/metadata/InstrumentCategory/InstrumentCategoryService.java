package com.finance.metadata.InstrumentCategory;

import com.finance.metadata.InstrumentCategory.dto.GetInstrumentCategoryRequest;
import com.finance.metadata.InstrumentCategory.dto.GetInstrumentCategoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InstrumentCategoryService {
    private final InstrumentCategoryRepository instrumentCategoryRepository;

    public InstrumentCategoryService(InstrumentCategoryRepository instrumentCategoryRepository) {
        this.instrumentCategoryRepository = instrumentCategoryRepository;
    }

    public List<GetInstrumentCategoryResponse> GetAllInstCategory(GetInstrumentCategoryRequest req) {
        List<InstrumentCategory> instrumentCategories = instrumentCategoryRepository.findAll();
        return instrumentCategories.stream()
                .map(ag -> new GetInstrumentCategoryResponse(
                        ag.getAssetGroupCode(),
                        ag.getInstrumentGroupCode(),
                        ag.getPayoffPatternCode(),
                        ag.getName()))
                .toList();
    }
}