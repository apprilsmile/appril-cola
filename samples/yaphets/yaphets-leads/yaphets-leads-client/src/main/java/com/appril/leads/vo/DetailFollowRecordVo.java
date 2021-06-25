package com.appril.leads.vo;


import com.appril.cola.dto.DTO;
import lombok.Data;

/**
 * 商机详情-跟进记录
 * @create 2021-06-16
 */
@Data
public class DetailFollowRecordVo extends DTO {

    //跟进记录id
    private String id;

    //跟进方式
    private Integer type;

    //跟进日期
    private String date;

}
