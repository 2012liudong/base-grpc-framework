package com.zd.baseframework.core.dao.systemlog.entry;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zd.baseframework.common.entity.dao.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_record")
public class SystemLogEntity extends BaseEntity {

    private String bizId;

    private String userId;

    private String trackUid;

    private String code;

    private String customCode;

    private Integer status;

    @TableField(value = "cid", fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private String cid;

    @TableField(value = "cname", fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private String cname;

}
