package com.ygq.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ythawed
 * @date 2019/12/21 0021
 */
@SpringBootApplication
@MapperScan("com.ygq.edu.mapper")
public class EduApp {

    public static void main(String[] args) {
        SpringApplication.run(EduApp.class, args);
    }
}
