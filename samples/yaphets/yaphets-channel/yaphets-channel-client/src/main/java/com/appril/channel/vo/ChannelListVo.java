package com.appril.channel.vo;

import com.appril.cola.dto.DTO;
import lombok.Data;

import java.util.List;

/**
 * @author zhangyang
 * @date 2021/6/28 10:13
 */
@Data
public class ChannelListVo extends DTO {

    /**
     * 客户gid
     */
    private String gid;

    /**
     * 渠道名称
     */
    private String name;

    /**
     * 备案情况
     */
    private String registered;

    /**
     *渠道类别
     */
    private List<String> categories;

    /**
     *注册地址
     */
    private String registerAddress;
}
