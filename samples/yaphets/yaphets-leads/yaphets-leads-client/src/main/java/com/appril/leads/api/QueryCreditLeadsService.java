package com.appril.leads.api;

import com.appril.cola.dto.SingleResponse;
import com.appril.leads.vo.CreditLeadsDetailVo;
import com.appril.leads.vo.query.CreditLeadsDetailQuery;

/**
 * 征信线索查询api
 */
public interface QueryCreditLeadsService {

    SingleResponse<CreditLeadsDetailVo> getDetail(CreditLeadsDetailQuery query);
}