package com.liandi.todoback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.liandi.todoback.dao"})
public class TodobackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodobackApplication.class, args);
    }

}
