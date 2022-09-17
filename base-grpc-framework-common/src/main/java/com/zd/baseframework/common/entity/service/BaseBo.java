package com.zd.baseframework.common.entity.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseBo {

    private String id;

    private LocalDateTime ctime;

    private LocalDateTime utime;
}
