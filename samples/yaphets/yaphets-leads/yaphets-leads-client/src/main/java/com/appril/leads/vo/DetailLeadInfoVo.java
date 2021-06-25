package com.appril.leads.vo;

import lombok.Data;

/**
 * 商机详情-商机信息
 * @create 2021-06-16
 */
@Data
public class DetailLeadInfoVo {

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String customerPhone;

    /**
     * 狮桥分等级
     */
    private String creditGrade;

    /**
     * 经销商名称
     */
    private String splName;

    /**
     * 经销商电话
     */
    private String splPhone;

    /**
     * 狮桥分查询时间
     */
    private String queryTime;

    /**
     * 次数同累计跟进次数
     */
    private String totalCount;

    /**
     * 跟进人
     */
    private String follower;
}
