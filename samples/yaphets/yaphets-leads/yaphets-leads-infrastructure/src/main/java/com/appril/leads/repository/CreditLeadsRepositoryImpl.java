package com.appril.leads.repository;


import com.appril.leads.entity.CrmCreditLeads;
import com.appril.leads.mapper.CrmCreditLeadsFollowMapper;
import com.appril.leads.mapper.CrmCreditLeadsMapper;
import com.appril.leads.model.CreditLeadsEntity;
import com.appril.leads.repository.CreditLeadsRepository;
import com.appril.leads.translator.CreditLeadsEntityTranslator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CreditLeadsRepositoryImpl implements CreditLeadsRepository {

    @Resource
    private CrmCreditLeadsMapper creditLeadsMapper;

    @Resource
    private CreditLeadsEntityTranslator entityTranslator;

    @Resource
    private CrmCreditLeadsFollowMapper creditLeadsFollowMapper;

    @Override
    public int save(CreditLeadsEntity creditLeadsEntity, String name) {
        CrmCreditLeads creditLeads = entityTranslator.toDto(creditLeadsEntity);
        if (creditLeads.getId() == null || creditLeads.getId() <= 0) {
            creditLeads.setLoseRecord(null);
            creditLeads.setGlobalId(String.valueOf(IdWorker.getId()));
            creditLeads.setCreator(name);
            creditLeads.setModifier(name);
            return creditLeadsMapper.insert(creditLeads);
        }
        //走更新逻辑
        creditLeads.setModifier(name);
        return creditLeadsMapper.updateById(creditLeads);
    }

    @Override
    public CreditLeadsEntity getById(Long id) {
        CrmCreditLeads crmCreditLead = creditLeadsMapper.selectById(id);
        return entityTranslator.toEntity(crmCreditLead);
    }

    @Override
    public CreditLeadsEntity getByGlobalId(String gid) {
        QueryWrapper<CrmCreditLeads> queryWrapper = new QueryWrapper<CrmCreditLeads>();
        queryWrapper.eq("global_id", gid);
        CrmCreditLeads crmCreditLead = creditLeadsMapper.selectOne(queryWrapper);
        return entityTranslator.toEntity(crmCreditLead);
    }


}
