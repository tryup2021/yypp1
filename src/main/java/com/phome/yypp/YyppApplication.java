package com.phome.yypp;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan("com.phome.yypp.dao")
public class YyppApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyppApplication.class, args);
        System.out.println(1);
        System.out.println("df_分支获取");
    }

}
