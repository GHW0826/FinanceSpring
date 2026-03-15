package com.finance.common.enums.domain.product.Category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 상품 그룹(Instrument Group) Enum
 * - NTS: Note (채권, 어음 등)
 * - OPT: Option (옵션)
 * - SWP: Swap (스왑)
 * - FWD: Forward (선도)
 * - SPT: Spot (현물)
 * - CFL: Cashflow (현금흐름 관련)
 */
public enum InstGrp {
    NOTE("NTS"),
    OPTION("OPT"),
    SWAP("SWP"),
    FORWARD("FWD"),
    SPOT("SPT"),
    CASHFLOW("CFL");

    private final String code;

    InstGrp(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static InstGrp fromJson(String input) {
        for (InstGrp t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown InstGrp: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}