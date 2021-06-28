package com.appril.channel.mapper;


import com.appril.channel.entity.CrmChannelInfo;
import com.appril.channel.vo.query.ChannelPageQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 渠道信息表 Mapper 接口
 * </p>
 *
 * @author appril
 * @since 2021-06-25
 */
public interface CrmChannelInfoMapper extends BaseMapper<CrmChannelInfo> {


    IPage<CrmChannelInfo> selectPageList(@Param("condition") ChannelPageQuery channelPageQuery, Page page);
}
