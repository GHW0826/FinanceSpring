package com.finance.common.common.dto.counterparty;

import java.util.List;

public record GetCounterpartyAllResponse(
        List<GetCounterpartyResponse> items
) { }

