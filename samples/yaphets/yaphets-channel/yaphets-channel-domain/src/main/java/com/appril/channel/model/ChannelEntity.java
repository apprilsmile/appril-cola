package com.appril.channel.model;


import com.appril.channel.repository.ChannelRepository;
import com.appril.channel.vo.ChannelAddress;
import com.appril.channel.vo.ChannelTagType;
import com.appril.channel.vo.ContactsInfo;
import com.appril.cola.domain.ApplicationContextHelper;
import com.appril.cola.domain.model.Entity;
import com.appril.cola.domain.repository.DataRepository;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ChannelEntity extends Entity<Long> {
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 渠道简称
     */
    private String shortName;


    /**
     * 渠道类型标签 [{code, name,sub_type:{code, name}},{code,name,sub_type:{code, name}},{code,name,sub_type:{code, name}}]
     */
    private List<ChannelTagType> tagTypes;

    /**
     * 详细地址, json字段， 含有经、纬度，省、市名称， 详细地址等
     */
    private ChannelAddress address;

    /**
     * 渠道联系人集合
     */
    private List<ContactsInfo> contactsInfos;

    /**
     * 当前操作日期
     */
    private Date currentDate;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 注册日期（成立日期）
     */
    private String esdate;


    @Override
    protected DataRepository getRepository() {
        return ApplicationContextHelper.getBean(ChannelRepository.class);
    }
}
