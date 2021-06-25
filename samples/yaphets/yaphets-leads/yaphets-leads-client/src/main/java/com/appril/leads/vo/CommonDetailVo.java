package com.appril.leads.vo;


import com.appril.cola.dto.DTO;
import lombok.Data;

import java.util.List;

/**
 * 管理角色-商机详情（跟进列表）
 * @create 2021-06-16
 */
@Data
public class CommonDetailVo extends DTO {

    //商机id
    private String id;

    //经销商名称
    private String splName;

    //跟进记录
    private List<DetailFollowRecordVo> followRecordList;

    //输单原因
    private DetailLostReasonVo lostReasonDetail;

    //是否显示输单
    private boolean canDisplayLost;

}
