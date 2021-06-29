package com.appril.leads.translator;


import com.appril.leads.entity.CrmCreditLeads;
import com.appril.leads.entity.CrmCreditLeadsFollow;
import com.appril.leads.model.CreditLeadsEntity;
import com.appril.leads.valueobj.LeadFollow;
import com.appril.leads.vo.FollowDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 征信线索转换类
 *
 * @author zy
 * @date 2021/6/10
 */
@Mapper(componentModel = "spring")
public interface CreditLeadsTranslator {

    @Mapping(target = "creationTime", source = "creationTime")
    @Mapping(target = "remark", source = "remark")
    @Mapping(target = "unapprovedReason", source = "unapprovedReason")
    @Mapping(target = "purpose", source = "purpose")
    @Mapping(target = "mode", source = "mode")
    @Mapping(target = "creditLeadsGlobalId", source = "creditLeadsGlobalId")
    @Mapping(target = "globalId", source = "globalId")
    LeadFollow followToVo(CrmCreditLeadsFollow resource);

}
