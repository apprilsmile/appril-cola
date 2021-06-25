package com.appril.leads.service;

import com.appril.cola.dto.SingleResponse;
import com.appril.leads.api.QueryCreditLeadsService;
import com.appril.leads.vo.AllDetailVo;
import com.appril.leads.vo.CommonDetailVo;
import com.appril.leads.vo.FollowDetailVo;

import java.util.Map;

/**
 * @author appril
 * @date 2021/6/25 17:41
 */
public class QueryCreditLeadsServiceImpl implements QueryCreditLeadsService {
    @Override
    public SingleResponse<Map<String, Object>> queryAllSelect() {
        return null;
    }

    @Override
    public SingleResponse<CommonDetailVo> followList(String id) {
        return null;
    }

    @Override
    public SingleResponse<AllDetailVo> leadDetail(String id) {
        return null;
    }

    @Override
    public SingleResponse<FollowDetailVo> followRecordDetail(String id) {
        return null;
    }

    @Override
    public SingleResponse<Boolean> isManageRole() {
        return null;
    }
}
