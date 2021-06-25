package com.appril.leads.api;

import com.appril.cola.dto.SingleResponse;
import com.appril.leads.vo.AllDetailVo;
import com.appril.leads.vo.CommonDetailVo;
import com.appril.leads.vo.FollowDetailVo;

import java.util.Map;

/**
 * 征信线索查询api
 */
public interface QueryCreditLeadsService {

    /**
     * 获取所有下拉框取值
     * @return
     */
    SingleResponse<Map<String, Object>> queryAllSelect();

    /**
     * 管理角色-跟进列表
     * @param id
     * @return
     */
    SingleResponse<CommonDetailVo> followList(String id);

    /**
     * 商机详情
     * @param id
     * @return
     */
    SingleResponse<AllDetailVo> leadDetail(String id);

    /**
     * 跟进记录详情
     * @param id
     * @return
     */
    SingleResponse<FollowDetailVo> followRecordDetail(String id);

    /**
     * 是否为管理角色
     * @return
     */
    SingleResponse<Boolean> isManageRole();
}