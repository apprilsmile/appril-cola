package com.appril.channel.repository;


import com.appril.channel.model.ChannelEntity;
import com.appril.channel.valueobj.ChannelInfo;
import com.appril.channel.vo.ContactInfo;
import com.appril.channel.vo.query.ChannelDetailQuery;
import com.appril.channel.vo.query.ChannelPageQuery;
import com.appril.cola.domain.repository.DataRepository;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface ChannelRepository extends DataRepository<Long, ChannelEntity> {

    Page<ChannelInfo> queryPageList(ChannelPageQuery channelPageQuery);

    List<ContactInfo> acquireContacts(String globalId);

    ChannelEntity getInfoByCondition(ChannelDetailQuery channelDetailQuery);
}
