package com.appril.channel.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系人
 *
 * @author appril
 * @date 2021/6/28 20:12
 */

@Data
public class ContactInfo implements Serializable {

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
    private int version ;

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
