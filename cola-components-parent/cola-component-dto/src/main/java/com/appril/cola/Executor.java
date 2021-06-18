package com.appril.cola;

import com.appril.cola.dto.Command;
import com.appril.cola.dto.Response;

/**
 * 执行器
 *
 * @author guoming.ren
 * @date 2021/4/1412:24 下午
 */
public interface Executor<T extends Command, R extends Response> {
    /**
     * 执行cmd
     *
     * @param command 待执行命令参数
     * @return 执行结果
     */
    R execute(T command);
}
