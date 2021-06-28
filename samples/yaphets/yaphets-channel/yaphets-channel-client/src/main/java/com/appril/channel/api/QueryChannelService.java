package com.appril.channel.api;

import com.appril.channel.vo.ChannelDetailVo;
import com.appril.channel.vo.ChannelListVo;
import com.appril.channel.vo.query.ChannelDetailQuery;
import com.appril.channel.vo.query.ChannelPageQuery;
import com.appril.cola.dto.MobilePageResponse;
import com.appril.cola.dto.SingleResponse;

/**
 * @author appril
 * @date 2021/06/25 16:44
 */
public interface QueryChannelService {

    MobilePageResponse<ChannelListVo> selectChannelList(ChannelPageQuery query);

    SingleResponse<ChannelDetailVo> getDetail(ChannelDetailQuery query);
}
