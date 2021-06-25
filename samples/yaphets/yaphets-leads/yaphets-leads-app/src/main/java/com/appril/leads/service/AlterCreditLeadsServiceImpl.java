package com.appril.leads.service;

import com.appril.cola.dto.Response;
import com.appril.leads.api.AlterCreditLeadsService;
import com.appril.leads.vo.comand.CreateCreditLeadsCmd;
import com.appril.leads.vo.comand.LeadFollowCmd;
import com.appril.leads.vo.comand.LostRecordCmd;

/**
 * @author appril
 * @date 2021/6/25 17:42
 */
public class AlterCreditLeadsServiceImpl implements AlterCreditLeadsService {
    @Override
    public Response saveCreditLeads(CreateCreditLeadsCmd cmd) {
        return null;
    }

    @Override
    public Response saveLostRecord(LostRecordCmd cmd) {
        return null;
    }

    @Override
    public Response saveFollow(LeadFollowCmd cmd) {
        return null;
    }
}
