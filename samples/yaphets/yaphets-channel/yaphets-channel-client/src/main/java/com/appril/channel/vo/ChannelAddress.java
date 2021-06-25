package com.appril.channel.vo;

import lombok.Data;

import java.util.List;

/**
 * 地址元语
 *
 * @author appril
 * @date 2021/6/25
 */
@Data
public class ChannelAddress {
    /**
     * 注册地址
     */
    private Address registered ;
    /**
     * 办公地址
     */
    private List<Address> businessList;
}
