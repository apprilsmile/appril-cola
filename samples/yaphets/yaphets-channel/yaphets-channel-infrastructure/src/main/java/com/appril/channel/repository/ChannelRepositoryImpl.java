package com.appril.channel.repository;

import com.appril.channel.mapper.CrmChannelContactMapper;
import com.appril.channel.mapper.CrmChannelInfoMapper;
import com.appril.channel.model.ChannelEntity;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
@Slf4j
public class ChannelRepositoryImpl implements ChannelRepository {

    @Resource
    private CrmChannelInfoMapper channelInfoMapper;

    @Resource
    private CrmChannelContactMapper channelContactMapper;

    @Override
    public int save(ChannelEntity channelEntity, String s) {
        return 0;
    }

    @Override
    public ChannelEntity getById(Long aLong) {
        return null;
    }

    @Override
    public ChannelEntity getByGlobalId(String s) {
        return null;
    }
}
