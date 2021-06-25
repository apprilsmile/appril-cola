package com.appril.leads.vo;


import com.appril.cola.dto.DTO;
import lombok.Data;

/**
 * 商机详情-输单原因
 * @create 2021-06-16
 */
@Data
public class DetailLostReasonVo extends DTO {

    /**
     * 输单类型/未追回原因
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
     * 输单日期
     */
    private String lostTime;

}
