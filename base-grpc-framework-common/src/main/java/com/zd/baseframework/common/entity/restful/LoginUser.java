package com.zd.baseframework.common.entity.restful;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {

    private String id;

    private String name;

    private String userName;

    private String phoneNumber;

    private String email;
}
