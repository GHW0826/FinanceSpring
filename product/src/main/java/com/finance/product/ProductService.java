package com.finance.product;

import com.finance.product.dto.SaveProductRequest;
import com.finance.product.dto.SaveProductResponse;
import com.finance.product.entity.Product;
import com.finance.product.entity.ProductFixedIncome;
import com.finance.product.entity.ProductSchedule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductFixedIncomeRepository fiRepository;
    private final ProductScheduleRepository productScheduleRepository;

    public ProductService(ProductScheduleRepository productScheduleRepository,
                          ProductFixedIncomeRepository fiRepository) {
        this.productScheduleRepository = productScheduleRepository;
        this.fiRepository = fiRepository;
    }

    public SaveProductResponse saveFiFwdBfd(SaveProductRequest dto) {
        ProductFixedIncome prodFi = new ProductFixedIncome(
                null,
                dto.getName(),
                dto.getStatus(),
                dto.getAssetGrp(),
                dto.getInstGrp(),
                dto.getPayoffPattern(),
                dto.getDum()
        );
        List<ProductSchedule> productSchedules = dto.createSchedule(prodFi);

        // productRepository.save(prod);
        List<ProductSchedule> savedSchedule = productScheduleRepository.saveAll(productSchedules);
        ProductFixedIncome saved = fiRepository.save(prodFi);

        return new SaveProductResponse(
                saved.getInstrumentId(),
                saved.getName(),
                saved.getStatus(),
                saved.getAssetGrp(),
                saved.getInstGrp(),
                saved.getPayoffPattern()
        );
    }
/*
    public List<GetUnderlyingBondResponse> getAllBonds() {
        List<UnderlyingBond> bonds = underlyingBondRepository.findAll();
        return new ArrayList<GetUnderlyingBondResponse>();
    }

    public GetUnderlyingBondResponse getBondByMdCd(String mdCd) {
        // mdCd 기준 단건 반환
        UnderlyingBond bond = underlyingBondRepository.findByUnderlyingCd(mdCd)
                .orElseThrow();
        // 예시용: return
        return new GetUnderlyingBondResponse();
    }




    public DeleteUnderlyingBondResponse delete(String mdCd) {
        underlyingBondRepository.deleteById(mdCd);
        return new DeleteUnderlyingBondResponse();
    }
    */
}