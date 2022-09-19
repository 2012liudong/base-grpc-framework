create table t_sys_record
(
    id          varchar(32)            not null primary key,
    biz_id      varchar(32) default '' null comment 'business id',
    user_id     varchar(32)            null comment 'operator userId',
    track_uid   varchar(128)           null comment 'tracklog UUID',
    code        varchar(32)            null comment 'primary operator code',
    custom_code varchar(32)            null comment 'slave operator code ',
    status      int                    null comment '1: enable, 0:disable',
    ctime       datetime               null comment 'create time',
    utime       datetime               null comment 'update time',
    cid         varchar(32)            null comment 'creater id',
    cname       varchar(32)            null comment 'creater name'
)