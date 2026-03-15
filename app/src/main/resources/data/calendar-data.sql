-- weekend_profile
insert into weekend_profile (weekend_profile_id, profile_code, description) values
    (1, 'SAT_SUN', '토/일 주말');

-- weekend_profile_day
insert into weekend_profile_day (weekend_profile_id, iso_weekday, is_weekend) values
    (1, 1, false), -- Mon
    (1, 2, false), -- Tue
    (1, 3, false), -- Wed
    (1, 4, false), -- Thu
    (1, 5, false), -- Fri
    (1, 6, true),  -- Sat
    (1, 7, true);  -- Sun

-- calendar
insert into calendar (calendar_id, calendar_code, calendar_name, calendar_type, country_id, region_code, timezone, active) values
    (1, 'kr_public', 'Korea Public Holiday Calendar', 'COUNTRY_PUBLIC', 1, null, 'Asia/Seoul', true),
    (2, 'usny', 'NYSE Holiday Calendar', 'EXCHANGE', 2, 'US-NY', 'America/New_York', true);


insert into calendar_exception (calendar_id, exception_date, is_business_day, exception_type, exception_name, observed_of, source) values
    (2, date '2026-01-01', false, 'HOLIDAY', 'New Year''s Day', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-01-19', false, 'HOLIDAY', 'Martin Luther King, Jr. Day', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-02-16', false, 'HOLIDAY', 'Washington''s Birthday', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-04-03', false, 'HOLIDAY', 'Good Friday', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-05-25', false, 'HOLIDAY', 'Memorial Day', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-06-19', false, 'HOLIDAY', 'Juneteenth National Independence Day', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-07-03', false, 'HOLIDAY', 'Independence Day (Observed)', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-09-07', false, 'HOLIDAY', 'Labor Day', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-11-26', false, 'HOLIDAY', 'Thanksgiving Day', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-11-27', true,  'EARLY_CLOSE', 'Day After Thanksgiving Early Close', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-12-24', true,  'EARLY_CLOSE', 'Christmas Eve Early Close', null, 'NYSE 2026 Hours & Calendars'),
    (2, date '2026-12-25', false, 'HOLIDAY', 'Christmas Day', null, 'NYSE 2026 Hours & Calendars');