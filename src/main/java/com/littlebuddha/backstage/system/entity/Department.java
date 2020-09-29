package com.littlebuddha.backstage.system.entity;

import com.littlebuddha.backstage.common.base.DataEntity;

/**
 * @author ck
 * @date 2020/9/29 14:24
 */
public class Department extends DataEntity<Department> {

    private String name;//部门名称
    private String parentId;//上级部门id
    private String parentIds;//上级所有部门id集合
    private Integer type;//类型 公司、部门及部门以下所设立的
    private Integer status;//数据是否启用
    private Integer sort;//排序

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
}
