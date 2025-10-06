package com.finance.product;

import com.finance.product.dto.SaveProductRequest;
import com.finance.product.dto.SaveProductResponse;
import com.finance.product.entity.Product;
import com.finance.product.entity.ProductFIFWDBFD;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductFixedIncomeRepository fiRepository;
    private final ProductScheduleRepository productScheduleRepository;

    public ProductService(ProductRepository productRepository,
                          ProductScheduleRepository productScheduleRepository,
                          ProductFixedIncomeRepository fiRepository) {
        this.productRepository = productRepository;
        this.productScheduleRepository = productScheduleRepository;
        this.fiRepository = fiRepository;
    }

    public SaveProductResponse saveFiFwdBfd(SaveProductRequest dto) {
        Product prod = mapToEntity(dto);

        Product saved = productRepository.save(prod);

        // List<ProductSchedule> productSchedules = dto.createSchedule(prodFi);
        // productRepository.save(prod);
//        List<ProductSchedule> savedSchedule = productScheduleRepository.saveAll(productSchedules);
  //      ProductFIFWDBFD saved = fiRepository.save(prodFi);

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

    private Product mapToEntity(SaveProductRequest req) {
        if (req instanceof SaveFiFwdBfdRequest fi) {
            return new ProductFIFWDBFD(
                    req.getName(),
                    req.getStatus(),
                    req.getAssetGrp(),
                    req.getInstGrp(),
                    req.getPayoffPattern(),
                    req.getProductSect(),   // null 허용이면 그대로 전달
                    req.getPosition(),
                    req.getModelSect(),
                    fi.getDum()
            );
        }
        return null;
    }
}