create table t_sys_record
(
    id          varchar(32)            not null primary key,
    biz_id      varchar(32) default '' null comment '业务ID',
    user_id     varchar(32)            null comment '操作用户ID',
    track_uid   varchar(128)           null comment '链路ID',
    code        varchar(32)            null comment '操作代码',
    custom_code varchar(32)            null comment '操作2级代码',
    status      int                    null comment '记录状态:1可查询，0不可查询',
    ctime       datetime               null,
    utime       datetime               null,
    cid         varchar(32)            null,
    cname       varchar(32)            null
)