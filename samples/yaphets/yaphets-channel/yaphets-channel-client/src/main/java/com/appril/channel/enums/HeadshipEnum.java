package com.appril.channel.enums;

import java.util.Arrays;

/**
 * 职务，1 企业法人、2 实际控制人、3 企业股东、4 负责人、5 业务经理、6其他
 *
 * @author appril
 * @date 2021/4/15 11:17
 */
public enum HeadshipEnum {

    BUSINESS_ENTITY(1, "企业法人"),
    ACTUAL_CONTROLLER(2, "实际控制人"),
    BUSINESS_SHAREHOLDER(3, "企业股东"),
    RESPONSIBLE_PERSON(4, "负责人"),
    BUSINESS_MANAGER(5, "业务经理"),
    OTHER_HEADSHIP(6, "其他");

    HeadshipEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private final Integer code;
    private final String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static HeadshipEnum getByCode(Integer code) {
        return Arrays.stream(HeadshipEnum.values()).filter(a -> a.getCode().equals(code)).findFirst().orElse(null);
    }
}
