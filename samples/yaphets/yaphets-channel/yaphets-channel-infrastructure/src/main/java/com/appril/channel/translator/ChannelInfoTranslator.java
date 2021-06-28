package com.appril.channel.translator;

import com.appril.channel.entity.CrmChannelInfo;
import com.appril.channel.vo.ChannelInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 渠道转换类
 *
 * @author zy
 * @date 2021/6/10
 */
@Mapper(componentModel = "spring")
public interface ChannelInfoTranslator {

    @Mapping(target = "registered", source = "registered")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "provinceCode", source = "provinceCode")
    @Mapping(target = "cityCode", source = "cityCode")
    @Mapping(target = "tagType", source = "tagType")
    @Mapping(target = "channelName", source = "channelName")
    @Mapping(target = "globalId", source = "globalId")
    @Mapping(target = "id", source = "id")
    ChannelInfo toVo(CrmChannelInfo resource);
}
