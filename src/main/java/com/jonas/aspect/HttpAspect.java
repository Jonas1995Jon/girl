package com.jonas.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author Jonas
 * 2018/8/22 14:50
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.jonas.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefor(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

//        HttpServletResponse response = attributes.getResponse();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

//        logger.info("执行GitlController包里所有方法前通过切面执行doBefor()方法");
    }

    @After("log()")
    public void doAfter(){
        logger.info("执行GitlController包里所有方法后通过切面执行doAfter()方法");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("respones={}", object.toString());
    }
}
