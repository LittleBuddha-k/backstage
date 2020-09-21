package com.littlebuddha.backstage.common.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ck
 * @date 2020/9/17 14:18
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //配置druid的监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> iniParams = new HashMap<>();
        iniParams.put("loginUsername","admin");
        iniParams.put("loginPassword","admin");
        iniParams.put("allow","");//不写 默认就是所有允许所有访问
        iniParams.put("deny","192.168.52.13");
        servletRegistrationBean.setInitParameters(iniParams);
        return servletRegistrationBean;
    }

    //2.配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterFilterRegistrationBean = new FilterRegistrationBean();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());

        Map<String,String> iniParams = new HashMap<>();
        iniParams.put("exclusions","*.js,*.css,/druid/*");
        filterFilterRegistrationBean.setInitParameters(iniParams);

        //拦截那些请求
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterFilterRegistrationBean;
    }
}
