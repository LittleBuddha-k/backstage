package com.littlebuddha.backstage.common.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.littlebuddha.backstage.common.config.shiro.realms.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ck
 * @date 2020/9/16 16:23
 */
@Configuration
public class ShiroConfig {

    //创建ShiroFilter--用来拦截所有请求的
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源
        Map<String,String> map = new HashMap<>();
//        map.put("/index","authc");
        map.put("/add","authc");
        map.put("/edit","authc");
        map.put("/index","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //配置系统公共资源
        //默认认证资源路径
        shiroFilterFactoryBean.setLoginUrl("/loginPage");
        return shiroFilterFactoryBean;
    }

    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //自定义Realm
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();

        //开启缓存管理
        //customerRealm.setCacheManager(new ShiroRedisConfig());
        //customerRealm.setCachingEnabled(true);//开启全局缓存
        //customerRealm.setAuthenticationCachingEnabled(true);
        //customerRealm.setAuthenticationCacheName("authenticationCache");
        //customerRealm.setAuthorizationCachingEnabled(true);
        //customerRealm.setAuthorizationCacheName("authorizationCache");
        return customerRealm;
    }

    //整合ShiroDialect,用来整合Shiro和Thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
