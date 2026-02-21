package com.finance.common.common.mapper.currency;

import com.finance.common.common.dto.currency.CreateCurrencyRequest;
import com.finance.common.common.dto.currency.CreateCurrencyResponse;
import com.finance.common.common.dto.currency.GetCurrencyResponse;
import com.finance.common.common.entity.currency.CurrencyMaster;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T20:57:11+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.14 (JetBrains s.r.o.)"
)
@Component
public class CurrencyMasterMapperImpl implements CurrencyMasterMapper {

    @Override
    public CurrencyMaster toEntity(CreateCurrencyRequest req) {
        if ( req == null ) {
            return null;
        }

        CurrencyMaster currencyMaster = new CurrencyMaster();

        currencyMaster.setCcy( req.Ccy() );
        currencyMaster.setDescription( req.Description() );

        return currencyMaster;
    }

    @Override
    public CreateCurrencyResponse toCreateResponse(CurrencyMaster e) {
        if ( e == null ) {
            return null;
        }

        String ccy = null;
        String description = null;

        ccy = e.getCcy();
        description = e.getDescription();

        CreateCurrencyResponse createCurrencyResponse = new CreateCurrencyResponse( ccy, description );

        return createCurrencyResponse;
    }

    @Override
    public GetCurrencyResponse toGetResponse(CurrencyMaster e) {
        if ( e == null ) {
            return null;
        }

        String ccy = null;
        String description = null;

        ccy = e.getCcy();
        description = e.getDescription();

        GetCurrencyResponse getCurrencyResponse = new GetCurrencyResponse( ccy, description );

        return getCurrencyResponse;
    }
}
