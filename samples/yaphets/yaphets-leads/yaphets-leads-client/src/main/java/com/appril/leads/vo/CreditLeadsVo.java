package com.appril.leads.vo;


import com.appril.cola.dto.DTO;
import lombok.Data;

import java.util.Date;

@Data
public class CreditLeadsVo extends DTO {


    /**
     * 全局id
     */
    private String globalId;

    /**
     * 客户经理姓名
     */
    private String userName;


    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String customerPhone;

    /**
     * 经销商名称
     */
    private String splName;

    /**
     * 狮桥分等级
     */
    private String creditGrade;

    /**
     * 狮桥分查询时间
     */
    private Date queryTime;

    /**
     * 商机阶段（1：未跟进，2：跟进中，3：赢单，4：输单）
     */
    private Integer status;

    /**
     * 为跟进天数
     */
    private String notFolloweDay;

    /**
     * 是否为本人的商机线索
     */
    private boolean myselfFlag;


}
