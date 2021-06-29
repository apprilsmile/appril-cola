package com.appril.leads.service;

import com.appril.cola.dto.SingleResponse;
import com.appril.leads.api.QueryCreditLeadsService;
import com.appril.leads.executor.query.CreditLeadsDetailQueryExe;
import com.appril.leads.vo.CreditLeadsDetailVo;
import com.appril.leads.vo.query.CreditLeadsDetailQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author appril
 * @date 2021/6/25 17:41
 */
@Service
public class QueryCreditLeadsServiceImpl implements QueryCreditLeadsService {

    @Resource
    private CreditLeadsDetailQueryExe detailQueryExe;

    @Override
    public SingleResponse<CreditLeadsDetailVo> getDetail(CreditLeadsDetailQuery query) {
        return detailQueryExe.execute(query);
    }
}
