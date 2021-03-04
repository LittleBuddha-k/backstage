package com.littlebuddha.backstage.modules.entity.system;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.modules.base.DataEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 菜单实体类
 * @author ck
 * @date 2020/8/19 11:23
 */
public class Menu extends DataEntity<Menu> {

    private String title;
    private String icon;
    private String href;
    private String target;
    private boolean hasChildren;
    private List<Menu> childrenList;       //子集
    private String sort;            //排序

    private Menu parent;            //父级menu
    private String parentId;        //父节点id
    private String parentIds;       //所有父级id

    private String showFlag;        //是否展示标识
    private String type;            //类型----菜单 、 按钮
    private String permission;      //权限标识

    @ExcelField(title = "菜单名字",align = 2,sort = 1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ExcelField(title = "图标",align = 2,sort = 2)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @ExcelField(title = "路径",align = 2,sort = 3)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @ExcelField(title = "目标",align = 2,sort = 4)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @ExcelField(title = "是否有子菜单",align = 2,sort = 5)
    public boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<Menu> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Menu> childrenList) {
        this.childrenList = childrenList;
    }

    @ExcelField(title = "排序",align = 2,sort = 6)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getParentId() {
        if(this.parent != null && StringUtils.isNotBlank(parent.getId())){
            this.parentId = parent.getId();
        }
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @ExcelField(title = "父类ids",align = 2,sort = 7)
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @ExcelField(title = "是否展示",align = 2,sort = 8)
    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    @ExcelField(title = "菜单类型",align = 2,sort = 9)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ExcelField(title = "权限标识",align = 2,sort = 10)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
