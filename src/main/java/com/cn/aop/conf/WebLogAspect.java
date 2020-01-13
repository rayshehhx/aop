package com.cn.aop.conf;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created on 2020/1/11.
 */

@Aspect
@Order(5)
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass());

    /**
     * 切点定义到类
     */
    @Pointcut("this(com.cn.aop.TestController)")
    public void webLog(){
    }

    /**
     * 切点定义到package
     */
    @Pointcut("execution(public * com.cn.aop.test.*.*(..))")
    public void webLog2(){
    }

    /**
     * 切点定义到接口
     */
    @Pointcut("this(com.cn.aop.service.IUserService)")
    public void webLog3(){
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

    @Before("webLog2()")
    public void doBefore2(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL2 : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD2 : " + request.getMethod());
        logger.info("IP 2: " + request.getRemoteAddr());
        logger.info("CLASS_METHOD2 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS2 : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog2()")
    public void doAfterReturning2(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE2 : " + ret);
    }



    @Before("webLog3()")
    public void doBefore3(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL3 : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD3 : " + request.getMethod());
        logger.info("IP 3: " + request.getRemoteAddr());
        logger.info("CLASS_METHOD3 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS3 : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog3()")
    public void doAfterReturning3(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE3 : " + ret);
    }
}
