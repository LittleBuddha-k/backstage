package com.littlebuddha.backstage.modules.system.entity;

import com.littlebuddha.backstage.modules.base.DataEntity;

import java.util.List;

/**
 * 操作用户实体类
 * @author ck
 * @date 2020/7/7 9:31
 */
public class Operator extends DataEntity<Operator> {

    //基本信息
    private String name;                 //操作用戶的名稱
    private String loginName;           //操作用戶的登錄名
    private String password;             //操作用戶的登錄密碼
    private String salt;                 //操作用戶的鹽值
    private String picture;              //操作用戶的頭像
    private Department department;       //操作用戶的部門
    private String workNumber;           //操作用戶的工號
    private String loginFlag;            //操作用戶的登陸標志---是否允許登錄

    //角色---只當作外鍵存在
    private Role role;                   //操作用戶的角色外鍵
    private List<Role> roles;            //操作用戶的角色列表

    //登錄ip
    private String loginIp;              //操作用戶的登錄ip
    private String loginAddress;         //操作用戶的登錄地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }
}
