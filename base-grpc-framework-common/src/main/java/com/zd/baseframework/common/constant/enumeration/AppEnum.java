package com.zd.baseframework.common.constant.enumeration;

/**
 * @author liudong
 * @Title: AppEnum
 * @Description 和系统相关的一些枚举值
 * - Status:数据通用状态
 * - DataSort: 数据排序标识
 * - Enable:通用状态
 * - SystemOperatorUser: 默认系统操作用户
 * @date 2022/2/6 12:27 PM
 */
public interface AppEnum {

    Integer getCode();

    String getText();

    /*通用状态值，表示0和1，语义由调用方决定*/
    enum Enable implements AppEnum {
        YES(1, "yes"),
        NO(0, "no"),
        UNKNOW(-99, "unknow"),
        ;
        private Integer code;
        private String text;

        Enable(Integer code, String text) {
            this.code = code;
            this.text = text;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getText() {
            return this.text;
        }
    }

    /*系统用户*/
    enum SystemOperatorUser implements AppEnum {
        SYSTEM(10000, "system"),
        ;

        private Integer code;
        private String text;

        SystemOperatorUser(Integer code, String text) {
            this.code = code;
            this.text = text;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getText() {
            return this.text;
        }
    }

    /*排序字段*/
    enum DataSort implements AppEnum {
        ASC(1,"asc"),
        DESC(0,"desc"),
        ;
        private Integer code;
        private String text;

        DataSort(Integer code, String text) {
            this.code = code;
            this.text = text;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getText() {
            return this.text;
        }
    }

    enum Status implements AppEnum {
        NORMAL(1, "normal"),
        DELETE(0, "delete"),
        DISCARD(-1, "discard"),
        UNKNOW(-99, "unknow"),
        ;

        private Integer code;
        private String text;

        Status(Integer code, String text) {
            this.code = code;
            this.text = text;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getText() {
            return this.text;
        }
    }
}
