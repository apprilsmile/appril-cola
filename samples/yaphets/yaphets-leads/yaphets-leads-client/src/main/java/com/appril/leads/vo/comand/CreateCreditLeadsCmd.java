package com.appril.leads.vo.comand;


import com.appril.cola.dto.Command;
import lombok.Data;

import java.util.Date;

/**
 * @author zy
 * @create 2021-06-10
 */
@Data
public class CreateCreditLeadsCmd extends Command {

    /**
     * 来源数据id
     */
    private String originId;

    /**
     * 客户经理工号
     */
    private String userNo;

    /**
     * 客户经理姓名
     */
    private String userName;

    /**
     * 客户经理组织机构id
     */
    private Long orgId;

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
     * 经销商电话
     */
    private String splPhone;

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
     * 输单记录（json）
     */
    private String loseRecord;

}
