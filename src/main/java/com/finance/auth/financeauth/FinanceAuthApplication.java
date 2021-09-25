package com.finance.auth.financeauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = ContextStackAutoConfiguration.class)
@ConfigurationPropertiesScan(basePackages = "com.finance.auth.financeauth.props")
public class FinanceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceAuthApplication.class, args);
    }

}
