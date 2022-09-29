package com.zd.baseframework.common.constant.enumeration;

/**
 * @author liudong
 * @Title: AppEnum
 * @Description enum definition only for app without business
 * - Status: common data record status
 * - DataSort: data record sort sign
 * - Enable: common operator status
 * - SystemOperatorUser: default system operator user
 * @date 2022/2/6 12:27 PM
 */
public interface AppEnum {

    Integer getCode();

    String getText();

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

        @Override
        public Integer getCode() {
            return this.code;
        }

        @Override
        public String getText() {
            return this.text;
        }
    }

    enum DefaultSystemUser implements AppEnum {
        SYSTEM(10000, "system"),
        ;

        private Integer code;
        private String text;

        DefaultSystemUser(Integer code, String text) {
            this.code = code;
            this.text = text;
        }

        @Override
        public Integer getCode() {
            return this.code;
        }

        @Override
        public String getText() {
            return this.text;
        }
    }

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

        @Override
        public Integer getCode() {
            return this.code;
        }

        @Override
        public String getText() {
            return this.text;
        }
    }

    enum Status implements AppEnum {
        NORMAL(1, "normal"),
        DELETE(-1, "delete"),
        HIDDEN(0, "hidden"),
        DISCARD(-2, "discard"),
        UNKNOW(-99, "unknow"),
        ;

        private Integer code;
        private String text;

        Status(Integer code, String text) {
            this.code = code;
            this.text = text;
        }

        @Override
        public Integer getCode() {
            return this.code;
        }

        @Override
        public String getText() {
            return this.text;
        }
    }
}
