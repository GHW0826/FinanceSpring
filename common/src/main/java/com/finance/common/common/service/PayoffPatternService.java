package com.finance.common.common.service;

import com.finance.common.common.dto.GetPayoffPatternRequest;
import com.finance.common.common.dto.GetPayoffPatternResponse;
import com.finance.common.common.entity.PayoffPattern;
import com.finance.common.common.repository.PayoffPatternRepository;
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