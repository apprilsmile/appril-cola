package com.appril.leads.executor.command;


import com.appril.leads.repository.CreditLeadsRepository;
import com.appril.leads.translator.CreditLeadsEntityTranslator;
import com.appril.leads.vo.comand.LeadFollowCmd;
import com.appril.cola.Executor;
import com.appril.cola.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 跟进记录保存
 *
 * @author zy
 * @create 2021-06-21
 */
@Component
@Slf4j
public class SaveFollowCmdExe implements Executor<LeadFollowCmd, Response> {

    @Resource
    private CreditLeadsRepository creditLeadsRepository;

    @Resource
    private CreditLeadsEntityTranslator translator;

    @Override
    public Response execute(LeadFollowCmd cmd) {
        return Response.buildSuccess();
    }
}
