package com.finance.product.help;

import com.finance.product.ProductService;
import com.finance.product.dto.SaveFiFwdBfdRequest;
import com.finance.product.dto.SaveProductRequest;
import com.finance.product.dto.SaveProductResponse;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public class SaveProductDispatcher {

    private final Map<Class<? extends SaveProductRequest>, Function<SaveProductRequest, SaveProductResponse>> handlerMap;

    public SaveProductDispatcher(ProductService productService) {
        // 각 타입별 핸들러 등록
        handlerMap = Map.of(
                SaveFiFwdBfdRequest.class, req -> productService.saveFiFwdBfd((SaveFiFwdBfdRequest) req)
            //     SaveFxFwdCshRequest.class, req -> productService.saveFxFwdCsh((SaveFxFwdCshRequest) req)
                // 타입 늘어나면 여기만 추가
        );
    }

    public SaveProductResponse dispatch(SaveProductRequest req) {
        Function<SaveProductRequest, SaveProductResponse> handler = handlerMap.get(req.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("Unsupported product type: " + req.getClass());
        }
        return handler.apply(req);
    }
}
