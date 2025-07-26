package com.finance.bond;

import java.util.Date;

public record SaveUnderlyingBondRequest(
        String underlyingCd
) { }