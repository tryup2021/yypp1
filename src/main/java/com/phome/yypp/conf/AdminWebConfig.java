package com.phome.yypp.conf;

import com.phome.yypp.handlerInterceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /* 设置/路径的view到指定的view */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 1、编写一个拦截器实现HandlerInterceptor接口
     * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
     * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //所有请求都被拦截包括静态资源
                .addPathPatterns("/**")
                //放行的请求
                .excludePathPatterns("/","/error","/favicon.ico","/login","/register","/swagger-ui.html",
                        "/css/**","/webjars/**","/fonts/**","/images/**","/js/**");
    }



    /**
     * @param registry:
     * @return: void
     * @author: t'r'y
     * @date: 2021/9/10 9:32
     * @description:
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }



}

