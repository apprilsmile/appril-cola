package com.appril.leads.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author appril
 * @date 2021/6/29 10:09
 */
@Data
public class CreditLeadsDetailVo {

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
     * 经销商地址
     */
    private String splAddress;

    /**
     * 经销商渠道类型
     */
    private List<String> splTagTypes;

    /**
     * 狮桥分等级
     */
    private String creditGrade;

    /**
     * 狮桥分查询时间
     */
    private String queryTime;

    /**
     * 商机阶段（1：未跟进，2：跟进中，3：赢单，4：输单）
     */
    private String status;
    /**
     * 跟进记录
     */
    private List<FollowDetail> follows;
 }
