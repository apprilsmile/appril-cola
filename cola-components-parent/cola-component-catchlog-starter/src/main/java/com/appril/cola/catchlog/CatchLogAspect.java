package com.appril.cola.catchlog;

import com.appril.cola.exception.BaseException;
import com.appril.cola.exception.BizException;
import com.appril.cola.exception.SysException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @ Description   :  Catching and Logging
 * @ Author        :  Frank Zhang
 * @ CreateDate    :  2020/11/09
 * @ Version       :  1.0
 */
@Aspect
@Slf4j
public class CatchLogAspect {

    /**
     * The syntax of pointcut : https://blog.csdn.net/zhengchao1991/article/details/53391244
     */
    @Pointcut("@within(com.appril.cola.catchlog.CatchAndLog) && execution(public * *(..))")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();

        StringBuilder logStr = new StringBuilder();
        appendLogRequest(joinPoint, logStr);

        Object response = null;
        try {
            response = joinPoint.proceed();
        } catch (Throwable e) {
            response = handleException(joinPoint, e);
        } finally {
            appendResult(startTime, response, logStr);
            log.info(logStr.toString());
        }

        return response;
    }

    private Object handleException(ProceedingJoinPoint joinPoint, Throwable e) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Class returnType = ms.getReturnType();

        if (e instanceof BizException) {
            log.warn("biz exception : " + e.getMessage());
            //在Debug的时候，对于BizException也打印堆栈
            if (log.isDebugEnabled()) {
                log.error(e.getMessage(), e);
            }
            return ResponseHandler.handle(returnType, (BaseException) e);
        }

        if (e instanceof SysException) {
            log.error("sys exception :");
            log.error(e.getMessage(), e);
            return ResponseHandler.handle(returnType, (BaseException) e);
        }

        log.error("unknown exception :");
        log.error(e.getMessage(), e);

        return ResponseHandler.handle(returnType, "unknown_error", e.getMessage());
    }

    private void appendLogRequest(ProceedingJoinPoint joinPoint, StringBuilder sb) {
        sb.append("Processing: ").append(joinPoint.getSignature().getDeclaringTypeName()).append(".").append(joinPoint.getSignature().getName())
                .append("(");
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            boolean isFirstArg = true;
            for (Object arg : args) {
                if (isFirstArg) {
                    isFirstArg = false;
                    sb.append(JSON.toJSONString(arg));
                } else {
                    sb.append(", ").append(JSON.toJSONString(arg));
                }
            }
        }
        sb.append(")");
    }

    private void appendResult(long start, Object response, StringBuilder sb) {
        sb.append(" cost:").append(System.currentTimeMillis() - start).append(" ms ")
                .append(" result: ").append(JSON.toJSONString(response));
    }
}
