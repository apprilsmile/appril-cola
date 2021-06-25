package com.appril.leads.model;

import com.appril.cola.domain.ApplicationContextHelper;
import com.appril.cola.domain.model.Entity;
import com.appril.cola.domain.repository.DataRepository;
import com.appril.leads.repository.CreditLeadsRepository;
import com.appril.leads.valueobj.LeadFollow;
import com.appril.leads.valueobj.LostRecord;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class CreditLeadsEntity extends Entity<Long> {


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
     * 是否为本人的商机线索
     */
    private boolean myselfFlag = false;

    /**
     * 输单记录（json）
     */
    private LostRecord loseRecord;

    /**
     * 跟进记录
     */
    private List<LeadFollow> leadFollowList=new ArrayList<>();

    /**
     * 跟进记录
     */
    private LeadFollow leadFollow;



    @Override
    protected DataRepository getRepository() {
        return ApplicationContextHelper.getBean(CreditLeadsRepository.class);
    }
}
