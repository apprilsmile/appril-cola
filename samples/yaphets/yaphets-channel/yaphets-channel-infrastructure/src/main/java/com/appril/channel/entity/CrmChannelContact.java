package com.appril.channel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author yz
 * @version V1.0
 * @description 渠道联系人表
 * @date 2021-04-22
 */
@Data
public class CrmChannelContact {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 全局id
     */
    private String globalId;

    /**
     * 渠道全局id
     */
    private String channelGlobalId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 职务，1企业法人、2实际控制人、3企业股东、4负责人、5业务经理、6其他
     */
    private Integer headship;

    /**
     * 备注
     */
    private String remark;

    /**
     * 事业部
     */
    private String business;

    /**
     * 版本
     */
    private int version = 1;

    /**
     * 是否删除（1：是，0：否）
     */
    private Integer deleted;

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