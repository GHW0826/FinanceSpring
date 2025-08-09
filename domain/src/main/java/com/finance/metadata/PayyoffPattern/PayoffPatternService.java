package com.finance.metadata.PayyoffPattern;

import com.finance.metadata.AssetGroup.dto.GetAssetGroupResponse;
import com.finance.metadata.PayyoffPattern.dto.GetPayoffPatternRequest;
import com.finance.metadata.PayyoffPattern.dto.GetPayoffPatternResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PayoffPatternService {
    private final PayoffPatternRepository payoffPatternRepository;

    public PayoffPatternService(PayoffPatternRepository payoffPatternRepository) {
        this.payoffPatternRepository = payoffPatternRepository;
    }

    public List<GetPayoffPatternResponse> GetAllPayoffPattern(GetPayoffPatternRequest req) {
        List<PayoffPattern> payoffPatterns = payoffPatternRepository.findAll();
        return payoffPatterns.stream()
                .map(ag -> new GetPayoffPatternResponse(ag.getCode(), ag.getName()))
                .toList();
    }
}