package com.appril.leads.vo;


import lombok.Data;

/**
 * 客户经理角色-商机详情
 * @create 2021-06-16
 */
@Data
public class AllDetailVo extends CommonDetailVo {

    //商机阶段
    private Integer status;

    //商机信息
    private DetailLeadInfoVo leadInfo;

    //是否可以输单
    private boolean canLost;

    //是否可以添加跟进记录
    private boolean canAdd;

}
