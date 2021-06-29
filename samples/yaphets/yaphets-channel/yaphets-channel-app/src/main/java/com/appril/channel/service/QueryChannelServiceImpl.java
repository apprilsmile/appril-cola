package com.appril.channel.service;

import com.appril.channel.api.QueryChannelService;
import com.appril.channel.executor.query.ChannelDetailQueryExe;
import com.appril.channel.executor.query.ChannelInfoQueryExe;
import com.appril.channel.executor.query.ChannelListQueryExe;
import com.appril.channel.vo.ChannelDetailVo;
import com.appril.channel.vo.ChannelInfoVo;
import com.appril.channel.vo.ChannelListVo;
import com.appril.channel.vo.query.ChannelDetailQuery;
import com.appril.channel.vo.query.ChannelPageQuery;
import com.appril.cola.dto.MobilePageResponse;
import com.appril.cola.dto.SingleResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @date 2021/6/25 17:30
 */
@Service
public class QueryChannelServiceImpl implements QueryChannelService {

    @Resource
    private ChannelListQueryExe listQueryExe;

    @Resource
    private ChannelDetailQueryExe detailQueryExe;

    @Resource
    private ChannelInfoQueryExe infoQueryExe;

    @Override
    public MobilePageResponse<ChannelListVo> selectChannelList(ChannelPageQuery query) {
        return listQueryExe.execute(query);
    }

    @Override
    public SingleResponse<ChannelDetailVo> getDetail(ChannelDetailQuery query) {
        return detailQueryExe.execute(query);
    }

    @Override
    public SingleResponse<ChannelInfoVo> getInfo(ChannelDetailQuery query ) {
        return infoQueryExe.execute(query);
    }
}
