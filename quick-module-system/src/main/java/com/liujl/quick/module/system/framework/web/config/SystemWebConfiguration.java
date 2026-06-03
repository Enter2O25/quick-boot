package com.liujl.quick.module.system.framework.web.config;

import com.liujl.quick.framework.swagger.config.QuickSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的 web 组件的 Configuration
 *
 * @author admin
 */
@Configuration(proxyBeanMethods = false)
public class SystemWebConfiguration {

    /**
     * system 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi systemGroupedOpenApi() {
        return QuickSwaggerAutoConfiguration.buildGroupedOpenApi("system");
    }

}
