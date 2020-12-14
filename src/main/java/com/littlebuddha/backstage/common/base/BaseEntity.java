package com.littlebuddha.backstage.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.littlebuddha.backstage.common.utils.UserUtils;
import com.littlebuddha.backstage.modules.system.entity.Operator;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * @author ck
 * @date 2020/8/17 14:36
 */
public abstract class BaseEntity<E> implements Serializable {

    private String id;//实体类的唯一标识

    /**
     * 当前用户
     */
    protected Operator currentUser;

    /**
     * 当前实体分页对象
     * @return
     */
    private Page<E> pageObject;

    private Integer page = 1;

    private Integer limit = 15;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public Operator getCurrentUser() {
        if(currentUser == null){
            currentUser = UserUtils.getPrincipal();
        }
        return currentUser;
    }

    public void setCurrentUser(Operator currentUser) {
        this.currentUser = currentUser;
    }

    @JsonIgnore
    @XmlTransient
    public Page<E> getPageObject() {
        if (pageObject == null){
            pageObject = new Page<E>();
        }
        return pageObject;
    }

    public Page<E> setPageObject(Page<E> page) {
        this.pageObject = page;
        return page;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";
}
