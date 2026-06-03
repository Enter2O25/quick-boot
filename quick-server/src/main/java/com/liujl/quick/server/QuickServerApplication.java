package com.liujl.quick.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 *
 * @author admin
 */
@SuppressWarnings("SpringComponentScan")
@SpringBootApplication(scanBasePackages = {"${quick.info.base-package}.server", "${quick.info.base-package}.module"})
public class QuickServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickServerApplication.class, args);
    }

}
