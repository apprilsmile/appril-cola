package com.appril.channel.vo;


import com.appril.cola.domain.valueobj.ValueObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 联系人
 *
 * @author appril
 * @date 2021/6/28 20:12
 */

@Data
public class ContactVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 全局id
     */
    private String globalId;

    /**
     * 联系人姓名
     */
    private String name;
    /**
     * 联系人手机号
     */
    private String phone;
    /**
     * 联系人职位
     */
    private String headship;
    /**
     * 备注
     */
    private String remark;

}
