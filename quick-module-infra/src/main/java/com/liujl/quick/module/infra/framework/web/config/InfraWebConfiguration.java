package com.liujl.quick.module.infra.framework.web.config;

import com.liujl.quick.framework.swagger.config.QuickSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * infra 模块的 web 组件的 Configuration
 *
 * @author admin
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return QuickSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}
