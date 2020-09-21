package com.littlebuddha.backstage.common.config.mybatis;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在使用Mybatis注解版时的开启驼峰的配置
 * @author ck
 * @date 2020/9/17 16:43
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){

            /**
             * 配置开启驼峰命名
             * @param configuration
             */
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
