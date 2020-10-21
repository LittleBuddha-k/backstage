package com.littlebuddha.backstage.system.entity;

import com.littlebuddha.backstage.common.base.DataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ck
 * @date 2020/9/29 14:24
 */
public class Department extends DataEntity<Department> {

    private String name;//部门名称
    private String parentId;//上级部门id
    private String parentIds;//上级所有部门id集合
    private Integer type;//类型 公司、部门及部门以下所设立的机构
    private Integer status;//数据是否启用
    private Integer sort;//排序
    private String fzr;//机构主管
    private String level;//机构级别
    private String phone;//电话

    private List<Department> childrenList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Department> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Department> childrenList) {
        this.childrenList = childrenList;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
