package com.drs.mes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesApplication.class, args);
        System.out.println("启动成功!");
    }

}
