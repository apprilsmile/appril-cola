package com.appril.leads.api;


import com.appril.cola.dto.Response;
import com.appril.leads.vo.comand.CreateCreditLeadsCmd;
import com.appril.leads.vo.comand.LeadFollowCmd;
import com.appril.leads.vo.comand.LostRecordCmd;

/**
 * 征信线索修改api
 */
public interface AlterCreditLeadsService {
    Response saveCreditLeads(CreateCreditLeadsCmd cmd);

    /**
     * 输单保存
     * @param cmd
     * @return
     */
    Response saveLostRecord(LostRecordCmd cmd);

    /**
     * 跟进记录保存
     * @param cmd
     * @return
     */
    Response saveFollow(LeadFollowCmd cmd);
}