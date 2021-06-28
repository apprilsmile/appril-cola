package com.appril.channel.vo.query;

import com.appril.cola.dto.SimplePageQuery;
import lombok.Data;

/**
 * @author zhangyang
 * @date 2021/6/28 10:13
 */
@Data
public class ChannelPageQuery extends SimplePageQuery {

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 省份code
     */
    private String provinceCode;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 备案状态：0否，1是
     */
    private int registered;

    /**
     * 渠道类型代码
     */
    private int channelType;
}
