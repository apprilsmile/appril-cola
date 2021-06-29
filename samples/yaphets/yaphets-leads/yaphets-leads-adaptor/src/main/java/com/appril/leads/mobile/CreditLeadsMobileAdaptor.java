package com.appril.leads.mobile;

import com.appril.cola.dto.SingleResponse;
import com.appril.leads.api.AlterCreditLeadsService;
import com.appril.leads.api.QueryCreditLeadsService;
import com.appril.leads.vo.CreditLeadsDetailVo;
import com.appril.leads.vo.query.CreditLeadsDetailQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 商机线索
 * @author appril
 * @date 2021-06-25
 */

@Slf4j
@RestController
@RequestMapping("/mobile/leads")
@Validated
public class CreditLeadsMobileAdaptor {

    @Resource
    private QueryCreditLeadsService queryCreditLeadsService;

    @GetMapping("/getDetail")
    public SingleResponse<CreditLeadsDetailVo> getDetail(@RequestParam("gid") String gid) {
        CreditLeadsDetailQuery query = new CreditLeadsDetailQuery();
        query.setGid(gid);
        return queryCreditLeadsService.getDetail(query);
    }
}
