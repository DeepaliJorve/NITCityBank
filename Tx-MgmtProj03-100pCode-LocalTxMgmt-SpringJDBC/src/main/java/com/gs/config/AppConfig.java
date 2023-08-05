package com.gs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class, PersistanceConfig.class, AOPConfig.class})
public class AppConfig {

}
