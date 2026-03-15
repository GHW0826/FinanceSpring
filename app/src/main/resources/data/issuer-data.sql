INSERT INTO issuer
(
    issuer_code,
    name,
    country_id,
    lei,
    parent_issuer_id,
    group_flag,
    active,
    description,
    created_at,
    updated_at
)
VALUES
('GOVT', 'Government', NULL, NULL, NULL, TRUE, TRUE, '국가/정부 발행체 그룹', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('AGENCY', 'Agency', NULL, NULL, NULL, TRUE, TRUE, '정부 산하 기관/공공기관 발행체 그룹', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('SUPRA', 'Supranational', NULL, NULL, NULL, TRUE, TRUE, '초국가 기구 발행체 그룹', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('BANK', 'Bank', NULL, NULL, NULL, TRUE, TRUE, '은행 발행체 그룹', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('CORP', 'Corporate', NULL, NULL, NULL, TRUE, TRUE, '일반 회사채 발행체 그룹', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('MUNI', 'Municipality', NULL, NULL, NULL, TRUE, TRUE, '지방정부/지자체 발행체 그룹', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);