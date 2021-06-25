package com.appril.leads.vo.comand;


import com.appril.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 跟进记录
 * @create 2021-06-16
 */
@Data
public class LeadFollowCmd extends Command {

    //商机id
    @NotBlank(message = "商机id不能为空")
    private String id;

    /**
     * 跟进方式：1：电话跟进，2：线下跟进
     */
    @NotNull(message = "跟进方式不能为空")
    private Integer mode;

    /**
     * 客户意向
     */
    @NotNull(message = "客户意向不能为空")
    private Integer purpose;

    /**
     * 未立项原因
     */
    @NotNull(message = "未立项原因不能为空")
    private Integer unapprovedReason;

    /**
     * 备注
     */
    @Size(max=50, message = "备注长度不能超过50个字符")
    private String remark;

}
