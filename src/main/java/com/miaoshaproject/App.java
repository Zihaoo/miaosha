package com.miaoshaproject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.miaoshaproject"} )
@RestController
@MapperScan("com.miaoshaproject.dao")
public class App 
{

    @RequestMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("project", "miaosha");
        response.put("type", "flash-sale-reference");
        response.put("message", "Spring Boot flash sale reference implementation");
        return response;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
