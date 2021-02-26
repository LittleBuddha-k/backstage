package com.littlebuddha.backstage.modules.entity.system;

import com.littlebuddha.backstage.modules.base.DataEntity;

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
    private List<Menu> child;       //子集

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }
}
