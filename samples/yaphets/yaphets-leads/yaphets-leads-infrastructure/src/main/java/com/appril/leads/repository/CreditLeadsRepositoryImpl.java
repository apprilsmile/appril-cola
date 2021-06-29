package com.appril.leads.repository;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.appril.leads.entity.CrmCreditLeads;
import com.appril.leads.entity.CrmCreditLeadsFollow;
import com.appril.leads.enums.CreditLeadStatusEnum;
import com.appril.leads.mapper.CrmCreditLeadsFollowMapper;
import com.appril.leads.mapper.CrmCreditLeadsMapper;
import com.appril.leads.model.CreditLeadsEntity;
import com.appril.leads.translator.CreditLeadsTranslator;
import com.appril.leads.valueobj.LeadFollow;
import com.appril.leads.valueobj.LostRecord;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CreditLeadsRepositoryImpl implements CreditLeadsRepository {

    @Resource
    private CrmCreditLeadsMapper creditLeadsMapper;

    @Resource
    private CreditLeadsTranslator entityTranslator;

    @Resource
    private CrmCreditLeadsFollowMapper creditLeadsFollowMapper;

    @Override
    public int save(CreditLeadsEntity creditLeadsEntity, String name) {
        return 0;
    }

    @Override
    public CreditLeadsEntity getById(Long id) {
        CrmCreditLeads crmCreditLead = creditLeadsMapper.selectById(id);
        return buildCreditLeadsEntity(crmCreditLead);
    }

    @Override
    public CreditLeadsEntity getByGlobalId(String gid) {
        CreditLeadsEntity creditLeadsEntity = new CreditLeadsEntity();
        QueryWrapper<CrmCreditLeads> queryWrapper = new QueryWrapper<CrmCreditLeads>();
        queryWrapper.eq("global_id", gid);
        CrmCreditLeads crmCreditLead = creditLeadsMapper.selectOne(queryWrapper);
        if (crmCreditLead!=null){
            creditLeadsEntity = buildCreditLeadsEntity(crmCreditLead);
            String loseRecord = crmCreditLead.getLoseRecord();
            if (StrUtil.isNotEmpty(loseRecord)){
                LostRecord lostRecord = JSONObject.parseObject(loseRecord, LostRecord.class);
                creditLeadsEntity.setLoseRecord(lostRecord);
            }
        }
        return creditLeadsEntity;
    }


    @Override
    public List<LeadFollow> acquireLeadsFollows(String globalId) {
        List<LeadFollow> leadFollows = new ArrayList<>();
        QueryWrapper<CrmCreditLeadsFollow> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CrmCreditLeadsFollow::getDeleted,0).eq(CrmCreditLeadsFollow::getCreditLeadsGlobalId,globalId);
        List<CrmCreditLeadsFollow> leadsFollows = creditLeadsFollowMapper.selectList(queryWrapper);
        if (CollectionUtil.isNotEmpty(leadsFollows)){
            leadFollows = leadsFollows.stream().map(e -> entityTranslator.followToVo(e)).collect(Collectors.toList());
        }
        return leadFollows;
    }

    private CreditLeadsEntity buildCreditLeadsEntity(CrmCreditLeads crmCreditLead) {
        CreditLeadsEntity entity = new CreditLeadsEntity();
        entity.setId(crmCreditLead.getId());
        entity.setGlobalId(crmCreditLead.getGlobalId());
        entity.setOriginId(crmCreditLead.getOriginId());
        entity.setCustomerName(crmCreditLead.getCustomerName());
        entity.setCustomerPhone(crmCreditLead.getCustomerPhone());
        entity.setSplName(crmCreditLead.getSplName());
        entity.setSplPhone(crmCreditLead.getSplPhone());
        entity.setUserNo(crmCreditLead.getUserNo());
        entity.setUserName(crmCreditLead.getUserName());
        entity.setOrgId(crmCreditLead.getOrgId());
        entity.setCreditGrade(crmCreditLead.getCreditGrade());
        entity.setQueryTime(crmCreditLead.getQueryTime());
        entity.setStatusEnum(CreditLeadStatusEnum.getByCode(crmCreditLead.getStatus()));
        String loseRecordStr = crmCreditLead.getLoseRecord();
        if (StrUtil.isNotEmpty(loseRecordStr)){
            LostRecord lostRecord = JSONObject.parseObject(loseRecordStr, LostRecord.class);
            entity.setLoseRecord(lostRecord);
        }
        return entity;
    }
}
