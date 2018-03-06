create table beach_dim
(beach_seq                      numeric
,beach_name                     varchar(60)
,county                         varchar(30)
,waterbody_name                 varchar(30)
,water_body_type                varchar(12)
,update_date                    datetime
,inland                         varchar(1)
,historical_flag                varchar(1)
);

create table monitor_site_dim
(monitor_site_seq               numeric
,beach_seq                      numeric
,station_name                   varchar(60)
,update_date                    datetime
,status                         varchar(1)
);
