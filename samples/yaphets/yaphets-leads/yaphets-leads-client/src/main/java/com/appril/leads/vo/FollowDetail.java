package com.appril.leads.vo;


import com.appril.cola.dto.DTO;
import lombok.Data;

/**
 * 跟进记录详情
 * @create 2021-06-17
 */
@Data
public class FollowDetail extends DTO {

    //跟进记录id
    private String id;

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

}
