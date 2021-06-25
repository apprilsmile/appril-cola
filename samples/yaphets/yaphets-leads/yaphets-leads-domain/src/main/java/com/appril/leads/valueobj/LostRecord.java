package com.appril.leads.valueobj;

import lombok.Data;

/**
 * 输单
 * @create 2021-06-18
 */

@Data
public class LostRecord {

    /**
     * 未追回原因
     */
    private Integer lostReason;

    /**
     * 竞对
     */
    private Integer rivalCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 输单时间
     */
    private String lostTime;

}
