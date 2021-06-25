package com.appril.leads.translator;


import com.appril.leads.entity.CrmCreditLeads;
import com.appril.leads.model.CreditLeadsEntity;
import com.appril.leads.vo.comand.CreateCreditLeadsCmd;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 征信线索转换类
 *
 * @author zy
 * @date 2021/6/10
 */
@Mapper(componentModel = "spring")
public interface CreditLeadsEntityTranslator {

    @Mapping(target = "originId", source = "originId")
    @Mapping(target = "userNo", source = "userNo")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "orgId", source = "orgId")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerPhone", source = "customerPhone")
    @Mapping(target = "splName", source = "splName")
    @Mapping(target = "creditGrade", source = "creditGrade")
    @Mapping(target = "queryTime", source = "queryTime")
    @Mapping(target = "status", source = "status")
    CreditLeadsEntity cmdToEntity(CreateCreditLeadsCmd resource);

    @Mapping(target = "originId", source = "originId")
    @Mapping(target = "userNo", source = "userNo")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "orgId", source = "orgId")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerPhone", source = "customerPhone")
    @Mapping(target = "splName", source = "splName")
    @Mapping(target = "creditGrade", source = "creditGrade")
    @Mapping(target = "queryTime", source = "queryTime")
    @Mapping(target = "status", source = "status")
    CrmCreditLeads toDto(CreditLeadsEntity entity);

    @Mapping(target = "originId", source = "originId")
    @Mapping(target = "userNo", source = "userNo")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "orgId", source = "orgId")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerPhone", source = "customerPhone")
    @Mapping(target = "splName", source = "splName")
    @Mapping(target = "creditGrade", source = "creditGrade")
    @Mapping(target = "queryTime", source = "queryTime")
    @Mapping(target = "status", source = "status")
    CreditLeadsEntity toEntity(CrmCreditLeads resource);

}
