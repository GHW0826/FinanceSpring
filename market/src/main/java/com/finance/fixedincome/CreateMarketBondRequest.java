package com.finance.fixedincome;

import java.util.Date;

public record CreateMarketBondRequest (
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