package com.appril.leads.vo.comand;


import com.appril.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 输单
 * @create 2021-06-18
 */
@Data
public class LostRecordCmd extends Command {

    //商机id
    @NotBlank(message = "商机id不能为空")
    private String id;

    /**
     * 未追回原因
     */
    @NotNull(message = "未追回原因不能为空")
    private Integer lostReason;

    /**
     * 竞对
     */
    private Integer rivalCode;

    /**
     * 备注
     */
    @Size(max=50, message = "备注长度不能超过50个字符")
    private String remark;

}
