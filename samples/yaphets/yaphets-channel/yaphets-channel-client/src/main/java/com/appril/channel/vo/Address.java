package com.appril.channel.vo;

import lombok.Data;

/**
 * 地址元语
 *
 * @author appril
 * @date 2021/6/25 4:13 下午
 */
@Data
public class Address {
    /**
     * 省份编码
     */
    private String provinceCode;
    /**
     * 省份名称
     */
    private String provinceName;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 区县
     */
    private String districtCode;
    /**
     * 区县名称
     */
    private String districtName;

    /**
     * 详细的地址
     */
    private String fullAddress;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;
}
