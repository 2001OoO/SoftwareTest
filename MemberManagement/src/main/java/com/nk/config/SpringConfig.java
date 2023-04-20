package com.nk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyBatisConfig.class,JdbcConfig.class})
@ComponentScan(value = "com.nk.service")
public class SpringConfig {
}
