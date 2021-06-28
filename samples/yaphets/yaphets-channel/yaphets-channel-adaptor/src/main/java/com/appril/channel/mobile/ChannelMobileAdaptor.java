package com.appril.channel.mobile;

import com.appril.channel.api.QueryChannelService;
import com.appril.channel.vo.ChannelDetailVo;
import com.appril.channel.vo.ChannelListVo;
import com.appril.channel.vo.query.ChannelDetailQuery;
import com.appril.channel.vo.query.ChannelPageQuery;
import com.appril.cola.catchlog.CatchAndLog;
import com.appril.cola.dto.MobilePageResponse;
import com.appril.cola.dto.SingleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 渠道
 *
 * @author appril
 * @create 2021-06-25
 */
@RestController
@RequestMapping("/mobile/channel")
@Validated
public class ChannelMobileAdaptor {

    @Resource
    private QueryChannelService queryChannelService;

    @GetMapping("/selectList")
    @CatchAndLog
    public MobilePageResponse<ChannelListVo> selectList(@RequestBody @Valid ChannelPageQuery query) {
        return queryChannelService.selectChannelList(query);
    }

    @GetMapping("/getDetail")
    @CatchAndLog
    public SingleResponse<ChannelDetailVo> getDetail(@RequestParam("gid") String gid) {
        ChannelDetailQuery query = new ChannelDetailQuery();
        query.setGid(gid);
        return queryChannelService.getDetail(query);
    }
}
