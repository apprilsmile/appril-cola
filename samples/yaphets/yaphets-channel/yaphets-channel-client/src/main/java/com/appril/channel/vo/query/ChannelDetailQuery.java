package com.appril.channel.vo.query;

import com.appril.cola.dto.Query;
import com.appril.cola.dto.SimplePageQuery;
import lombok.Data;

/**
 * @author zhangyang
 * @date 2021/6/28 10:13
 */
@Data
public class ChannelDetailQuery extends Query {

    /**
     * 渠道名称
     */
    private String name;


    /**
     *  全局id
     */
    private String gid ;
}
