package com.appril.channel.repository;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.appril.channel.entity.CrmChannelContact;
import com.appril.channel.entity.CrmChannelInfo;
import com.appril.channel.enums.RegisteredEnum;
import com.appril.channel.mapper.CrmChannelContactMapper;
import com.appril.channel.mapper.CrmChannelInfoMapper;
import com.appril.channel.model.ChannelEntity;
import com.appril.channel.translator.ChannelContactTranslator;
import com.appril.channel.translator.ChannelInfoTranslator;
import com.appril.channel.valueobj.ChannelInfo;
import com.appril.channel.vo.ChannelAddress;
import com.appril.channel.vo.ChannelTagType;
import com.appril.channel.vo.ContactInfo;
import com.appril.channel.vo.query.ChannelDetailQuery;
import com.appril.channel.vo.query.ChannelPageQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ChannelRepositoryImpl implements ChannelRepository {

    @Resource
    private CrmChannelInfoMapper channelInfoMapper;

    @Resource
    private CrmChannelContactMapper channelContactMapper;

    @Resource
    private ChannelInfoTranslator translator;

    @Resource
    private ChannelContactTranslator contactTranslator;

    @Override
    public int save(ChannelEntity channelEntity, String s) {
        return 0;
    }

    @Override
    public ChannelEntity getById(Long aLong) {
        return null;
    }

    @Override
    public ChannelEntity getByGlobalId(String globalId) {
        ChannelEntity channelEntity = new ChannelEntity();
        QueryWrapper<CrmChannelInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CrmChannelInfo::getDeleted, 0).eq(CrmChannelInfo::getGlobalId, globalId);
        CrmChannelInfo channelInfo = channelInfoMapper.selectOne(queryWrapper);
        if (channelInfo != null) {
            this.buildChannelEntity(channelEntity,channelInfo);
        }
        return channelEntity;
    }

    @Override
    public Page<ChannelInfo> queryPageList(ChannelPageQuery channelPageQuery) {
        Page<ChannelInfo> page = new Page<>();
        IPage<CrmChannelInfo> channelPageList = channelInfoMapper.selectPageList(channelPageQuery, new Page(channelPageQuery.getPageIndex(), channelPageQuery.getPageSize()));
        List<CrmChannelInfo> records = channelPageList.getRecords();
        if (CollectionUtil.isNotEmpty(records)) {
            List<ChannelInfo> infoVos = records.stream().map(e -> translator.toVo(e)).collect(Collectors.toList());
            page.setRecords(infoVos);
            page.setTotal(channelPageList.getTotal());
        }
        return page;
    }

    @Override
    public List<ContactInfo> acquireContacts(String globalId) {
        List<ContactInfo> contactsInfos = new ArrayList<>();
        QueryWrapper<CrmChannelContact> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CrmChannelContact::getDeleted, 0).eq(CrmChannelContact::getChannelGlobalId, globalId);
        List<CrmChannelContact> channelContacts = channelContactMapper.selectList(queryWrapper);
        if (CollectionUtil.isNotEmpty(channelContacts)) {
            contactsInfos = channelContacts.stream().map(e -> contactTranslator.translatorTo(e)).collect(Collectors.toList());
        }
        return contactsInfos;
    }

    @Override
    public ChannelEntity getInfoByCondition(ChannelDetailQuery channelDetailQuery) {
        ChannelEntity entity = new ChannelEntity();
        QueryWrapper<CrmChannelInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CrmChannelInfo::getDeleted,0);
        String gid = channelDetailQuery.getGid();
        String name = channelDetailQuery.getName();
        if (StrUtil.isEmpty(gid)&&StrUtil.isEmpty(name)){
            return null;
        }
        if (StrUtil.isNotEmpty(gid)){
            queryWrapper.lambda().eq(CrmChannelInfo::getGlobalId,gid);
        }
        if(StrUtil.isNotEmpty(name)){
            queryWrapper.lambda().like(CrmChannelInfo::getChannelName,name);

        }
        List<CrmChannelInfo> channelInfos = channelInfoMapper.selectList(queryWrapper);
        if (CollectionUtil.isNotEmpty(channelInfos)){
            CrmChannelInfo crmChannelInfo = channelInfos.get(0);
            this.buildChannelEntity(entity,crmChannelInfo);
        }
        return entity;
    }

    private void buildChannelEntity(ChannelEntity channelEntity, CrmChannelInfo channelInfo) {
        channelEntity.setId(channelInfo.getId());
        channelEntity.setGlobalId(channelInfo.getGlobalId());
        String addressStr = channelInfo.getAddress();
        if (StrUtil.isNotEmpty(addressStr)) {
            ChannelAddress address = JSONObject.parseObject(addressStr, ChannelAddress.class);
            channelEntity.setAddress(address);
        }
        channelEntity.setChannelName(channelInfo.getChannelName());
        channelEntity.setCreditCode(channelInfo.getCreditCode());
        channelEntity.setRegistered(RegisteredEnum.getByCode(channelInfo.getRegistered()));
        String tagTypeStr = channelInfo.getTagType();
        if (StrUtil.isNotEmpty(tagTypeStr)) {
            List<ChannelTagType> tagType = JSONObject.parseArray(tagTypeStr, ChannelTagType.class);
            channelEntity.setTagTypes(tagType);
        }
    }

}
