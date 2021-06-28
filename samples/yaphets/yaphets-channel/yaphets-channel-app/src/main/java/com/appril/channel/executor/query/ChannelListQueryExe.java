package com.appril.channel.executor.query;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.appril.channel.enums.RegisteredEnum;
import com.appril.channel.repository.ChannelRepository;
import com.appril.channel.vo.ChannelAddress;
import com.appril.channel.vo.ChannelInfo;
import com.appril.channel.vo.ChannelListVo;
import com.appril.channel.vo.ChannelTagType;
import com.appril.channel.vo.query.ChannelPageQuery;
import com.appril.cola.Executor;
import com.appril.cola.dto.MobilePageResponse;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyang
 * @date 2021/6/28 10:16
 */
@Component
public class ChannelListQueryExe implements Executor<ChannelPageQuery, MobilePageResponse<ChannelListVo>> {

    @Resource
    private ChannelRepository channelRepository;

    @Override
    public MobilePageResponse<ChannelListVo> execute(ChannelPageQuery channelPageQuery) {
        int pageIndex = channelPageQuery.getPageIndex();
        int pageSize = channelPageQuery.getPageSize();
        List<ChannelListVo> listVos = new ArrayList<>();
        Page<ChannelInfo> page = channelRepository.queryPageList(channelPageQuery);
        long total = page.getTotal();
        boolean isExistNextPage = false;
        if (total>pageIndex*pageSize){
            isExistNextPage = true;
        }
        this.buildListVos(listVos,page);
        return MobilePageResponse.of(listVos,isExistNextPage,pageSize,pageIndex);
    }

    private void buildListVos(List<ChannelListVo> listVos, Page<ChannelInfo> page) {
        List<ChannelInfo> records = page.getRecords();
        if (CollectionUtil.isNotEmpty(records)){
            for (ChannelInfo infoVo:records){
                ChannelListVo listVo = new ChannelListVo();
                listVo.setGid(infoVo.getGlobalId());
                listVo.setName(infoVo.getChannelName());
                RegisteredEnum registered = RegisteredEnum.getByCode(infoVo.getRegistered());
                listVo.setRegistered(registered==null?"未知":registered.getName());
                listVo.setRegisterAddress(convertAddress(infoVo.getAddress()));
                listVo.setCategories(convertCategories(infoVo.getTagType()));
                listVos.add(listVo);
            }
        }
    }

    private String convertAddress(String addressJsonStr) {
        String addressStr = "";
        if (StrUtil.isNotEmpty(addressJsonStr)){
            ChannelAddress address = JSONObject.parseObject(addressJsonStr, ChannelAddress.class);
            if (address!=null&&address.getRegistered()!=null) {
                addressStr = address.getRegistered().getFullAddress();
            }
        }
        return addressStr;
    }

    private List<String> convertCategories(String tagType) {
        List<String> list = new ArrayList<>();
        if (StrUtil.isNotEmpty(tagType)){
            List<ChannelTagType> channelTagTypes =  JSONObject.parseArray(tagType,ChannelTagType.class);
            if (CollectionUtils.isNotEmpty(channelTagTypes)){
                list = channelTagTypes.stream().map(ChannelTagType::getName).collect(Collectors.toList());
            }
        }
        return list;
    }
}
