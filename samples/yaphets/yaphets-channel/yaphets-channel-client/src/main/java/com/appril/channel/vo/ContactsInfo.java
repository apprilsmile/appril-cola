package com.appril.channel.vo;


import com.appril.cola.domain.valueobj.ValueObject;
import lombok.Data;

/**
 * 联系人值对象
 *
 * @author chenyu.yang
 * @date 2021/4/14 20:12
 */

@Data
public class ContactsInfo extends ValueObject<String> {

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
    private String position;
    /**
     * 编号，备用
     */
    private Long contractNo;

    /**
     * 渠道id
     */
    private Long channelId;
    /**
     * 备注
     */
    private String remark;

}
