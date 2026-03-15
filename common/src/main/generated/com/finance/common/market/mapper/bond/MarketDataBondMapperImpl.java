package com.finance.common.market.mapper.bond;

import com.finance.common.market.dto.bond.CreateMarketBondRequest;
import com.finance.common.market.dto.bond.CreateMarketBondResponse;
import com.finance.common.market.entity.MarketDataBondMaster;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T20:57:11+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.14 (JetBrains s.r.o.)"
)
@Component
public class MarketDataBondMapperImpl implements MarketDataBondMapper {

    @Override
    public MarketDataBondMaster toEntity(CreateMarketBondRequest req) {
        if ( req == null ) {
            return null;
        }

        MarketDataBondMaster marketDataBondMaster = new MarketDataBondMaster();

        marketDataBondMaster.setMarketDataCode( req.MarketDataCode() );
        marketDataBondMaster.setName( req.Name() );
        marketDataBondMaster.setIssuerCode( req.IssuerCode() );
        marketDataBondMaster.setIsinCode( req.ISINCode() );
        marketDataBondMaster.setListingSection( req.ListingSection() );
        marketDataBondMaster.setInterestPayMethod( req.InterestPayMethod() );
        marketDataBondMaster.setAssetSecuritizationClassification( req.AssetSecuritizationClassification() );
        marketDataBondMaster.setSubordinationClassification( req.SubordinationClassification() );
        marketDataBondMaster.setIssueDate( req.IssueDate() );
        marketDataBondMaster.setMaturityDate( req.MaturityDate() );
        marketDataBondMaster.setOriginSourceCode( req.OriginSourceCode() );
        marketDataBondMaster.setIssueKind( req.IssueKind() );
        marketDataBondMaster.setIssuePurpose( req.IssuePurpose() );
        marketDataBondMaster.setDescription( req.Description() );

        return marketDataBondMaster;
    }

    @Override
    public CreateMarketBondResponse toResponse(MarketDataBondMaster entity) {
        if ( entity == null ) {
            return null;
        }

        String marketDataCode = null;
        String name = null;
        String isinCode = null;
        Date issueDate = null;
        Date maturityDate = null;

        marketDataCode = entity.getMarketDataCode();
        name = entity.getName();
        isinCode = entity.getIsinCode();
        issueDate = entity.getIssueDate();
        maturityDate = entity.getMaturityDate();

        CreateMarketBondResponse createMarketBondResponse = new CreateMarketBondResponse( marketDataCode, name, isinCode, issueDate, maturityDate );

        return createMarketBondResponse;
    }

    @Override
    public void updateEntity(CreateMarketBondRequest req, MarketDataBondMaster entity) {
        if ( req == null ) {
            return;
        }
    }
}
