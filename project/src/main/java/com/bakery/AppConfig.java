package com.bakery;

import com.bakery.dao.CompanyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class);
    }
}
