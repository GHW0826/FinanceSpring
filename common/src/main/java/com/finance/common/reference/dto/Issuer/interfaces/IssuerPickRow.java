package com.finance.common.reference.dto.Issuer.interfaces;

public interface IssuerPickRow {
    String getIssuerCode();
    String getName();
    String getShortName();
    String getCountryIso2();
    String getLei();
    String getParentIssuerCode(); // alias로 받기
    Boolean getActiveFlag();
}
