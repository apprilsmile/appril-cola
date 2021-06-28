package com.appril.channel.vo;

import com.appril.cola.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zhangyang
 * @date 2021/6/28 12:12
 */
@Data
public class ChannelDetailVo extends DTO {

    private String gid;

    /***
     * 客户名称简称
     */
    private String name;

    /**
     * 地址
     */
    private String registerAddress;

    /**
     * 渠道主类别
     */
    private List<String> categories;

    /**
     * 备案情况
     */
    private String registered;

    /**
     * 社会统一信用代码
     */
    private String creditCode;

    /**
     * 联系人
     */
    private List<ContactVo> contacts;

}
