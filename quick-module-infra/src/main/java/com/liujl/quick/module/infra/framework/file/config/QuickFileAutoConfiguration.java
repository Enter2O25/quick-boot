package com.liujl.quick.module.infra.framework.file.config;

import com.liujl.quick.module.infra.framework.file.core.client.FileClientFactory;
import com.liujl.quick.module.infra.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author admin
 */
@Configuration(proxyBeanMethods = false)
public class QuickFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
