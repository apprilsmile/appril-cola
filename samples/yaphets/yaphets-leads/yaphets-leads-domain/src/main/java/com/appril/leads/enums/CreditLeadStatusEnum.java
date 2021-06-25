package com.appril.leads.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @Description: 商机阶段
 * @CreateDate: 2021-06-15
 **/
@AllArgsConstructor
@Getter
public enum CreditLeadStatusEnum {

    NOT_FOLLOW(1, "未跟进"),

    FOLLOWING(2, "跟进中"),

    WIN(3, "赢单"),

    LOST(4, "输单");

    private final Integer code;

    private final String name;

    public static CreditLeadStatusEnum getByCode(Integer code) {
        return Arrays.stream(CreditLeadStatusEnum.values()).filter(a -> a.getCode().equals(code)).findFirst().orElse(null);
    }
}
