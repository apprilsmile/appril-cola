package com.appril.leads.valueobj;

import lombok.Data;

import java.util.Date;

/**
 * 跟进记录
 * @create 2021-06-17
 */

@Data
public class LeadFollow {

    /**
     * 全局id
     */
    private String globalId;

    /**
     * 征信线索全局id
     */
    private String creditLeadsGlobalId;

    /**
     * 跟进方式：1：电话跟进，2：线下跟进
     */
    private Integer mode;

    /**
     * 客户意向
     */
    private Integer purpose;

    /**
     * 未立项原因
     */
    private Integer unapprovedReason;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date creationTime;

}
