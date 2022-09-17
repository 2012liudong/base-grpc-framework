package com.zd.baseframework.common.util;

import com.zd.baseframework.common.entity.restful.EnumVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnumVoUtil<T extends com.zd.baseframework.common.constant.enumeration.AppEnum>{
    public List<EnumVo> buildEnumVo(Map<Integer, T> t){
        List<EnumVo> enumVos = new ArrayList<>();
        for (Map.Entry<Integer, T> entry : t.entrySet()) {
            EnumVo temp = new EnumVo();
            temp.setCode(entry.getValue().getCode());
            temp.setText(entry.getValue().getText());
            enumVos.add(temp);
        }
        return enumVos;
    }
}
