package com.finance.bond;

import java.util.Date;

public record CreateMarketBondResponse(
        String mdCd,
        String name,
        String ccy,
        String ccy2,
        String time,
        String assetGroup,
        String mktdataGroup,
        String mktdataSect,
        Date lastMktDate,
        String freq,
        String srcCd,
        int impDiff,
        String impTime,
        String fileId
) { }