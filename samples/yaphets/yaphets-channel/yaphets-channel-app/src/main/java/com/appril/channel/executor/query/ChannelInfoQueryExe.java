package com.appril.channel.executor.query;

import cn.hutool.core.collection.CollectionUtil;
import com.appril.channel.model.ChannelEntity;
import com.appril.channel.repository.ChannelRepository;
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
public class ChannelInfoQueryExe implements Executor<ChannelDetailQuery, SingleResponse<ChannelInfoVo>> {

    @Resource
    private ChannelRepository channelRepository;

    @Override
    public SingleResponse<ChannelInfoVo> execute(ChannelDetailQuery channelDetailQuery) {
        ChannelInfoVo channelInfoVo = new ChannelInfoVo();
        ChannelEntity channelEntity = channelRepository.getInfoByCondition(channelDetailQuery);
        if(channelEntity!=null){
            ChannelAddress address = channelEntity.getAddress();
            if (address!=null&&address.getRegistered()!=null){
                channelInfoVo.setAddress(address.getRegistered().getFullAddress());
            }
            channelInfoVo.setChannelName(channelEntity.getChannelName());
            List<ChannelTagType> tagTypes = channelEntity.getTagTypes();
            if (CollectionUtil.isNotEmpty(tagTypes)){
                List<String> typeNms = tagTypes.stream().map(ChannelTagType::getName).collect(Collectors.toList());
                channelInfoVo.setTagTypes(typeNms);
            }
        }
        return SingleResponse.of(channelInfoVo);
    }

}
