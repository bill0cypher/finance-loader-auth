package com.finance.auth.financeauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FinanceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceAuthApplication.class, args);
    }

}
