package com.b.test;

import org.apache.logging.log4j.core.config.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ApplicationInit implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(ApplicationInit.class);

    public void run(String... args) {
        logger.debug("应用初始化入口。。。。。。。。。。。。。。。。。。。。。。。。。。");
    }
}
