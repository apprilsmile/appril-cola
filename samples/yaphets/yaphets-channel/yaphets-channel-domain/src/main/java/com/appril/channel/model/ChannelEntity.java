package com.appril.channel.model;


import com.appril.channel.enums.RegisteredEnum;
import com.appril.channel.repository.ChannelRepository;
import com.appril.channel.vo.ChannelAddress;
import com.appril.channel.vo.ChannelTagType;
import com.appril.channel.vo.ContactInfo;
import com.appril.cola.domain.ApplicationContextHelper;
import com.appril.cola.domain.model.Entity;
import com.appril.cola.domain.repository.DataRepository;
import lombok.Data;

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
     * 备案状态：0否，1是
     */
    private RegisteredEnum registered;

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
    private List<ContactInfo> contactInfos;


    /**
     * 统一社会信用代码
     */
    private String creditCode;


    @Override
    protected DataRepository getRepository() {
        return ApplicationContextHelper.getBean(ChannelRepository.class);
    }

    public List<ContactInfo> acquireContacts() {
        ChannelRepository repository = (ChannelRepository) getRepository();
        return repository.acquireContacts(globalId);
    }
}
