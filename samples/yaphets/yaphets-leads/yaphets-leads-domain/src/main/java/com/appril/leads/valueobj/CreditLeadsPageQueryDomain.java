package com.appril.leads.valueobj;


import com.appril.cola.dto.SimplePageQuery;
import lombok.Data;

import java.util.List;

@Data
public class CreditLeadsPageQueryDomain extends SimplePageQuery {

    /**
     * 客户姓名、经销商名称
     */
    private String customerOrSplname;

    /**
     *
     */
    private String startTime;

    /**
     *
     */
    private String endTime;
    /**
     * 狮桥分等级
     */
    private String creditGrade;

    /**
     * 商机阶段（1：未跟进，2：跟进中，3：赢单，4：输单）
     */
    private String status;

    /**
     *机构id
     */
    private List<Long> orgIds;

    /**
     * 客户经理工号
     */
    private String userNo;


    /**
     * 列表数据，1我的，2团队/区域
     */
    private Integer listDataType;
}
