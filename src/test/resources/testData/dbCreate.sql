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

create table bch_users
(person_id                      numeric
,apex_name                      varchar(25)
);

create table sanitary_data_fact
(beach_seq                      numeric
,monitor_site_seq               numeric
,ecoli_sample_type              varchar(30)
,sample_date_time               timestamp without time zone
,no_gulls                       numeric
,no_geese                       numeric
,no_dogs                        numeric
,no_animals_other               numeric
,animals_other_desc             varchar(50)
,num_loons                      numeric
,num_herr_gulls                 numeric
,num_ring_gulls                 numeric
,num_cormorants                 numeric
,num_longtail_ducks             numeric
,num_scoter                     numeric
,num_horn_grebe                 numeric
,num_rednecked_grebe            numeric
,num_dead_fish                  numeric
,num_other                      numeric
,num_other_desc                 varchar(50)
,float_street_litter            varchar(1)
,float_food                     varchar(1)
,float_medical                  varchar(1)
,float_sewage                   varchar(1)
,float_bldg_materials           varchar(1)
,float_fishing                  varchar(1)
,float_other                    varchar(1)
,float_other_desc               varchar(50)
,debris_street_litter           varchar(1)
,debris_food                    varchar(1)
,debris_medical                 varchar(1)
,debris_sewage                  varchar(1)
,debris_bldg_materials          varchar(1)
,debris_fishing                 varchar(1)
,debris_household               varchar(1)
,debris_tar                     varchar(1)
,debris_oil                     varchar(1)
,debris_other                   varchar(1)
,debris_other_desc              varchar(255)
,debris_amount                  varchar(30)
,no_in_water                    numeric
,num_out_of_water               numeric
,no_people_boating              numeric
,no_people_fishing              numeric
,no_people_surfing              numeric
,no_people_windsurfing          numeric
,no_people_diving               numeric
,no_people_clamming             numeric
,no_people_other                numeric
,no_people_other_desc           varchar(50)
,air_temp                       numeric
,air_units                      varchar(1)
,wind_speed                     numeric
,wind_speed_units               varchar(30)
,wind_dir_degrees               numeric
,wind_dir_desc                  varchar(30)
,weather_desc                   varchar(30)
,rainfall_last_event            varchar(5)
,rainfall                       numeric
,rainfall_units                 varchar(30)
,rainfall_stn_desc              varchar(60)
,wave_height                    numeric
,wave_height_units              varchar(30)
,est_act_flag                   varchar(1)
,wave_direction                 varchar(10)
,wave_conditions                varchar(30)
,current_speed                  numeric
,longshore_current_units        varchar(30)
,shoreline_current_dir          varchar(30)
,ph                             numeric
,color_change                   varchar(1)
,color_description              varchar(50)
,odor_description               varchar(50)
,odor_other_description         varchar(50)
,avg_water_temp                 numeric
,avg_water_temp_units           varchar(30)
,clarity_desc                   varchar(30)
,ntu                            numeric
,secchi_tube_cm                 numeric
,algae_nearshore                varchar(30)
,algae_on_beach                 varchar(30)
,algae_type_periphyton          varchar(1)
,algae_type_globular            varchar(1)
,algae_type_freefloating        varchar(1)
,algae_type_other               varchar(1)
,algae_type_other_desc          varchar(50)
,algae_color_lt_green           varchar(1)
,algae_color_brght_green        varchar(1)
,algae_color_drk_green          varchar(1)
,algae_color_yellow             varchar(1)
,algae_color_brown              varchar(1)
,algae_color_other              varchar(1)
,algae_color_other_desc         varchar(50)
,part_1_comments                varchar(1000)
,part2_comments                 varchar(1000)
,part3_comments                 varchar(1000)
,part4_comments                 varchar(1000)
,date_entered                   datetime
,date_updated                   datetime
,missing_required_flag          varchar(1)
,sampler_seq                    numeric
,data_entry_seq                 numeric
)