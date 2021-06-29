package com.appril.leads.executor.query;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.appril.channel.api.QueryChannelService;
import com.appril.channel.vo.ChannelInfoVo;
import com.appril.channel.vo.query.ChannelDetailQuery;
import com.appril.cola.Executor;
import com.appril.cola.dto.Response;
import com.appril.cola.dto.SingleResponse;
import com.appril.leads.enums.CreditLeadStatusEnum;
import com.appril.leads.model.CreditLeadsEntity;
import com.appril.leads.repository.CreditLeadsRepository;
import com.appril.leads.valueobj.LeadFollow;
import com.appril.leads.vo.CreditLeadsDetailVo;
import com.appril.leads.vo.FollowDetail;
import com.appril.leads.vo.query.CreditLeadsDetailQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author appril
 * @date 2021/6/28 10:16
 */
@Component
public class CreditLeadsDetailQueryExe implements Executor<CreditLeadsDetailQuery, SingleResponse<CreditLeadsDetailVo>> {

    @Resource
    private CreditLeadsRepository repository;

    @Resource
    private QueryChannelService queryChannelService;

    @Override
    public SingleResponse<CreditLeadsDetailVo> execute(CreditLeadsDetailQuery creditLeadsDetailQuery) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CreditLeadsDetailVo detailVo = new CreditLeadsDetailVo();
        List<FollowDetail> follows = new ArrayList<>();
        CreditLeadsEntity creditLeadsEntity = repository.getByGlobalId(creditLeadsDetailQuery.getGid());
        List<LeadFollow> followList =  creditLeadsEntity.acquireLeadsFollows();
        if (CollectionUtil.isNotEmpty(followList)){
            for (LeadFollow leadFollow:followList) {
                FollowDetail followDetail = new FollowDetail();
                followDetail.setId(leadFollow.getGlobalId());
                followDetail.setMode(leadFollow.getMode());
                followDetail.setPurpose(leadFollow.getPurpose());
                followDetail.setRemark(leadFollow.getRemark());
                followDetail.setUnapprovedReason(leadFollow.getUnapprovedReason());
                follows.add(followDetail);
            }
            detailVo.setFollows(follows);
        }
        detailVo.setGlobalId(creditLeadsEntity.getGlobalId());
        detailVo.setUserName(creditLeadsEntity.getUserName());
        detailVo.setCustomerName(creditLeadsEntity.getCustomerName());
        detailVo.setCustomerPhone(creditLeadsEntity.getCustomerPhone());
        detailVo.setCreditGrade(creditLeadsEntity.getCreditGrade());
        detailVo.setSplName(creditLeadsEntity.getSplName());
        Date queryTime = creditLeadsEntity.getQueryTime();
        if (queryTime!=null){
            detailVo.setQueryTime(sdf.format(queryTime));
        }
        CreditLeadStatusEnum statusEnum = creditLeadsEntity.getStatusEnum();
        detailVo.setStatus(statusEnum!=null?statusEnum.getName():"");
        if (StrUtil.isNotEmpty(creditLeadsEntity.getSplName())){
            ChannelDetailQuery query = new ChannelDetailQuery();
            query.setName(creditLeadsEntity.getSplName());
            SingleResponse<ChannelInfoVo> channelInfoResponse = queryChannelService.getInfo(query);
            if (channelInfoResponse.isSuccess()&&channelInfoResponse.getData()!=null){
                ChannelInfoVo channelInfo = channelInfoResponse.getData();
                detailVo.setSplAddress(channelInfo.getAddress());
                detailVo.setSplTagTypes(channelInfo.getTagTypes());
            }
        }
        return SingleResponse.of(detailVo);
    }
}
