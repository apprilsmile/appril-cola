package com.appril.channel.translator;

import com.appril.channel.entity.CrmChannelContact;
import com.appril.channel.entity.CrmChannelInfo;
import com.appril.channel.vo.ContactInfo;
import com.appril.channel.vo.ContactVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 渠道联系人转换类
 *
 * @author zy
 * @date 2021/6/10
 */
@Mapper(componentModel = "spring")
public interface ChannelContactTranslator {

    @Mapping(target = "modifiedTime", source = "modifiedTime")
    @Mapping(target = "modifier", source = "modifier")
    @Mapping(target = "creationTime", source = "creationTime")
    @Mapping(target = "creator", source = "creator")
    @Mapping(target = "deleted", source = "deleted")
    @Mapping(target = "business", source = "business")
    @Mapping(target = "remark", source = "remark")
    @Mapping(target = "headship", source = "headship")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "channelGlobalId", source = "channelGlobalId")
    @Mapping(target = "globalId", source = "globalId")
    @Mapping(target = "id", source = "id")
    ContactInfo translatorTo(CrmChannelContact resource);

    @Mapping(target = "remark", source = "remark")
    @Mapping(target = "headship", source = "headship")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "globalId", source = "globalId")
    ContactVo toVo(ContactInfo resource);
}
