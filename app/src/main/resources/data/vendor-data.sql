INSERT INTO vendor
(
    vendor_code,
    name,
    homepage_url,
    active,
    description,
    created_at,
    updated_at
)
VALUES
('KIS', 'Korea Investors Service', 'https://www.kisrating.com', true, '국내 신용평가 및 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('KOREA_RATING', 'Korea Ratings', 'https://www.korearatings.com', true, '국내 신용평가 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('NICE', 'NICE Investors Service', 'https://www.nicerating.com', true, '국내 신용평가 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('FN_GUIDE', 'FnGuide', 'https://www.fnguide.com', true, '국내 금융 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('YONHAP_INFO', 'Yonhap Infomax', 'https://www.infomax.co.kr', true, '국내 금융시장 정보 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('KOFIA', 'Korea Financial Investment Association', 'https://www.kofia.or.kr', true, '채권/금투협 관련 시장 정보 제공기관', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('KRX', 'Korea Exchange', 'https://www.krx.co.kr', true, '한국거래소', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('BOK', 'Bank of Korea', 'https://www.bok.or.kr', true, '한국은행', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('BLOOMBERG', 'Bloomberg L.P.', 'https://www.bloomberg.com', true, '글로벌 시장 데이터 및 가격 정보 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('LSEG', 'London Stock Exchange Group', 'https://www.lseg.com', true, '구 Refinitiv 포함 글로벌 시장 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('REFINITIV', 'Refinitiv', 'https://www.refinitiv.com', true, '시장 데이터 벤더(현 LSEG 계열/레거시 코드 유지용)', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('ICE', 'Intercontinental Exchange', 'https://www.ice.com', true, '거래소 및 시장 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('SNP_GMI', 'S&P Global Market Intelligence', 'https://www.spglobal.com', true, '글로벌 신용/시장 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('MOODYS', 'Moody''s Analytics', 'https://www.moodys.com', true, '신용 리스크 및 시장 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('MSCI', 'MSCI Inc.', 'https://www.msci.com', true, '지수 및 리스크 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('MARKIT', 'IHS Markit', 'https://ihsmarkit.com', true, 'CDS/채권/OTC 데이터 벤더(레거시 식별용)', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('SIX', 'SIX Financial Information', 'https://www.six-group.com', true, '글로벌 증권식별/시장 데이터 벤더', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('IDC', 'Interactive Data Corporation', NULL, true, '가격 평가/시세 관련 레거시 벤더 식별용', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('EUROCLEAR', 'Euroclear', 'https://www.euroclear.com', true, '국제 증권예탁 및 관련 데이터 제공기관', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('CLEARSTREAM', 'Clearstream',  'https://www.clearstream.com', true, '국제 증권예탁 및 관련 데이터 제공기관', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('DTCC', 'Depository Trust & Clearing Corporation', 'https://www.dtcc.com', true, '청산/결제 및 참조 데이터 기관', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('ISDA', 'International Swaps and Derivatives Association',  'https://www.isda.org', true, '파생상품 표준 및 관련 참조정보 기관', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('INTERNAL', 'Internal Manual Input', NULL, true, '내부 수기 등록/운영 입력용 벤더 코드', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('ETL', 'Internal ETL Pipeline', NULL, true, '사내 ETL/수집 배치 생성 데이터 식별용', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('LEGACY', 'Legacy Migration Source', NULL, true, '레거시 시스템 이관 데이터 식별용', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);