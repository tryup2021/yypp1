package com.phome.yypp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理整个web controller的异常
 */
@Slf4j
@ControllerAdvice     //该注解会自动处理异常
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)  //处理指定的异常，Exception表示所有的异常都交给他处理
    /*当你想要处理多个异常时，可使用花括号括起来 ｛异常1，异常2｝*/
    public String handleArithException(Exception e, HttpServletRequest request){
        //输出异常原因
        log.error("异常是：{}",e);
        String requestURI = request.getRequestURI();  //获取当前url地址
        request.setAttribute("msg","异常错误"); //输出异常错误
        return requestURI; //返回指定的视图
    }
}