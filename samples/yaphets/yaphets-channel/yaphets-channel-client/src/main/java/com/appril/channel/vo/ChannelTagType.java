package com.appril.channel.vo;

import lombok.Data;

import java.util.List;

/**
 * @author appril
 * @date 2021/6/25 13:40
 */
@Data
public class ChannelTagType {
    /**
     * 渠道类型
     */
    private String code;
    /**
     * 渠道名称
     */
    private String name;
    /**
     * 二级类型
     */
    private List<ChannelTagType> subType;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelTagType channelTagType = (ChannelTagType) o;
        if (!code.equals(channelTagType.code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 19 * result + name.hashCode();
        return result;
    }
}
