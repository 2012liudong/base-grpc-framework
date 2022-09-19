package com.zd.baseframework.common.entity.dao;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liudong
 * @Title: BaseEntity
 * @Description base class of entity(dao)
 * id：pk
 * ctime：record create time
 * utime：record last modify time
 * @date 2022/1/23 6:55 PM
 */
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
public abstract class BaseEntity<T extends Model<T>> extends Model<T> {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "ctime", fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ctime;

    @TableField(value = "utime", fill = FieldFill.INSERT_UPDATE, insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date utime;

//    private String cid;
//    private String cname;
}
