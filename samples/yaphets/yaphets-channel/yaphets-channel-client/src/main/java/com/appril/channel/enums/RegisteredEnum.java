package com.appril.channel.enums;

import java.util.Arrays;

/**
 * 备案状态：0否，1是
 *
 * @author zhangyang
 * @date 2021/4/15 11:17
 */
public enum RegisteredEnum {
    HAS_REGISTERED(1, "已备案"),
    NOT_REGISTERED(0, "未备案");

    RegisteredEnum(int code, String name) {
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

    public static RegisteredEnum getByCode(Integer code) {
        return Arrays.stream(RegisteredEnum.values()).filter(a -> a.getCode().equals(code)).findFirst().orElse(null);
    }
}
