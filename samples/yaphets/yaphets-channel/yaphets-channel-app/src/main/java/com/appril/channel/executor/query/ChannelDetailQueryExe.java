package com.appril.channel.executor.query;

import cn.hutool.core.collection.CollectionUtil;
import com.appril.channel.enums.RegisteredEnum;
import com.appril.channel.model.ChannelEntity;
import com.appril.channel.repository.ChannelRepository;
import com.appril.channel.translator.ChannelContactTranslator;
import com.appril.channel.vo.*;
import com.appril.channel.vo.query.ChannelDetailQuery;
import com.appril.cola.Executor;
import com.appril.cola.dto.SingleResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyang
 * @date 2021/6/28 10:16
 */
@Component
public class ChannelDetailQueryExe implements Executor<ChannelDetailQuery, SingleResponse<ChannelDetailVo>> {

    @Resource
    private ChannelRepository channelRepository;

    @Resource
    private ChannelContactTranslator contactTranslator;

    @Override
    public SingleResponse<ChannelDetailVo> execute(ChannelDetailQuery channelDetailQuery) {
        ChannelDetailVo detailVo = new ChannelDetailVo();
        ChannelEntity channelEntity = channelRepository.getByGlobalId(channelDetailQuery.getGid());
        List<ContactInfo> contactList = channelEntity.acquireContacts();
        this.buildResult(detailVo,channelEntity,contactList);
        return SingleResponse.of(detailVo);
    }

    private void buildResult(ChannelDetailVo detailVo,ChannelEntity channelEntity, List<ContactInfo> contactList) {
        detailVo.setGid(channelEntity.getGlobalId());
        detailVo.setName(channelEntity.getChannelName());
        List<ChannelTagType> tagTypes = channelEntity.getTagTypes();
        if (CollectionUtil.isNotEmpty(tagTypes)){
            List<String> typeList = tagTypes.stream().map(ChannelTagType::getName).collect(Collectors.toList());
            detailVo.setCategories(typeList);
        }
        detailVo.setCreditCode(channelEntity.getCreditCode());
        RegisteredEnum registered = channelEntity.getRegistered();
        detailVo.setRegistered(registered==null?"未知":registered.getName());
        ChannelAddress address = channelEntity.getAddress();
        if (address!=null&&address.getRegistered()!=null){
            detailVo.setRegisterAddress(address.getRegistered().getFullAddress());
        }
        if (CollectionUtil.isNotEmpty(contactList)){
            List<ContactVo> contactVos = contactList.stream().map(e -> contactTranslator.toVo(e)).collect(Collectors.toList());
            detailVo.setContacts(contactVos);
        }
    }
}
