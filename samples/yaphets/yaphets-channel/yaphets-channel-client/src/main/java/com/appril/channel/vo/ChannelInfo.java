package com.appril.channel.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author appril
 * @date 2021/6/28 10:53
 */
@Data
public class ChannelInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 全局id
     */
    private String globalId;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道简称
     */
    private String shortName;

    /**
     * 渠道类型模式： 1公司 2个人
     */
    private Integer modeType;

    /**
     * 渠道类型标签,  json字符串[{code, name,sub_type:{code, name}},{code,name,sub_type:{code, name}},{code,name,sub_type:{code, name}}]
     */
    private String tagType;

    /**
     * 经营范围json。1=重卡，2=轻卡。数据格式 [{code:,title:}]
     */
    private String businessScope;

    /**
     * 省code
     */
    private String provinceCode;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 详细地址, json字段， 含有经、纬度，省、市名称， 详细地址等
     */
    private String address;

    /**
     * 风控信息，json字符串
     */
    private String riskInfo;

    /**
     * 备案状态：0否，1是
     */
    private Integer registered;

    /**
     * 合作状态:  1->cold, 2->warm,3->hot
     */
    private Integer status;

    /**
     * 扩展信息,json字符串
     */
    private String extend;

    /**
     * 版本
     */
    private int version = 1;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 注册日期（成立日期）
     */
    private String esdate;

    /**
     * 是否删除（1：是，0：否）
     */
    private Integer deleted;

    /**
     * 经销商ID
     */
    private Long splId;

    /**
     * 挂靠公司ID
     */
    private Long lnkCompId;

    /**
     * 可支持的挂靠类型
     */
    private String suppLnkPrjTypCd;

    /**
     * 渠道来源：0：自主创建
     * ChannelSourceTypeEnum
     */
    private Integer sourceType;

    /**
     * 创建人工号-姓名
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date creationTime;

    /**
     * 修改人工号-姓名
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modifiedTime;
}
