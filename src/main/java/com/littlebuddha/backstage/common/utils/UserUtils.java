package com.littlebuddha.backstage.common.utils;

import com.littlebuddha.backstage.modules.entity.system.Menu;
import com.littlebuddha.backstage.modules.entity.system.Operator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取当前登录用户信息
 * @author ck
 * @date 2020/7/29 15:03
 */
@Service
public class UserUtils {

    public static Operator getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        Operator currentUser = (Operator) subject.getPrincipal();
        return currentUser;
    }

    /**
     * 获取当前登录者对象
     */
    public static Operator getPrincipal(){
        try{
            Subject subject = SecurityUtils.getSubject();
            Operator principal = (Operator)subject.getPrincipal();
            if (principal != null){
                return principal;
            }
//			subject.logout();
        }catch (UnavailableSecurityManagerException e) {

        }catch (InvalidSessionException e){

        }
        return null;
    }

    /**
     * 获取当前用户菜单列表
     */
    public List<Menu> getCurrentUserMenu(){
        Subject subject = SecurityUtils.getSubject();
        Operator principal = (Operator) subject.getPrincipal();
        return null;
    }
}
