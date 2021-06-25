package com.appril.leads.executor.command;


import com.appril.leads.model.CreditLeadsEntity;
import com.appril.leads.repository.CreditLeadsRepository;
import com.appril.leads.translator.CreditLeadsEntityTranslator;
import com.appril.leads.vo.comand.CreateCreditLeadsCmd;
import com.appril.cola.Executor;
import com.appril.cola.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 *
 * @author zy
 * @create 2021-06-06
 */
@Component
@Slf4j
public class CreateCreditLeadsCmdExe implements Executor<CreateCreditLeadsCmd, Response> {

    @Resource
    private CreditLeadsRepository creditLeadsRepository;

    @Resource
    private CreditLeadsEntityTranslator translator;

    @Override
    public Response execute(CreateCreditLeadsCmd cmd) {
        CreditLeadsEntity entity = translator.cmdToEntity(cmd);
        creditLeadsRepository.save(entity,"system");
        return Response.buildSuccess();
    }
}
