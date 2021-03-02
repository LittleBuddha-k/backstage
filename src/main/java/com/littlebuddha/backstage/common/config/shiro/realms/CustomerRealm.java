package com.littlebuddha.backstage.common.config.shiro.realms;

import com.littlebuddha.backstage.modules.entity.system.Operator;
import com.littlebuddha.backstage.modules.mapper.system.MenuMapper;
import com.littlebuddha.backstage.modules.mapper.system.OperatorMapper;
import com.littlebuddha.backstage.modules.mapper.system.RoleMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ck
 * @date 2020/9/16 16:40
 */
@Service
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private OperatorMapper operatorMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String password = String.valueOf(usernamePasswordToken.getPassword());
        String name = usernamePasswordToken.getUsername();
//        String password = String.valueOf(usernamePasswordToken.getPassword());
        Operator operator = new Operator();
        operator.setName(name);
        List<Operator> operators = operatorMapper.findByName(operator);
        //根据token的用户、密码去数据库查询是否存在
        if(null == operators || operators.size() == 0){
            return null;//返回null抛异常UnknownAccountException
        }
        //返回的信息是从数据库中取出的的信息-----密码认证由shiro自身去做
        Operator loginPrinciple = operators.get(0);
        String salt = loginPrinciple.getSalt();
        return new SimpleAccount(loginPrinciple,loginPrinciple.getPassword(), ByteSource.Util.bytes(salt),operator.getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");//根据身份信息
        Operator principal = (Operator) principalCollection.getPrimaryPrincipal();
        //连接数据库
        //查询角色列表
        Set<String> roles = roleMapper.findRolesByOperator(principal);
        //查询权限列表
        //Set<String> permissions = menuMapper.findPermissionsByOperator(principal);
        Set<String> permissions = new HashSet<>();
        //todo查询权限,根据user的id查询权限表的权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上面查询到的权限列表赋值给SimpleAuthorizationInfo并返回
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}
