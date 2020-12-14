package com.littlebuddha.backstage.common.utils;

import com.littlebuddha.backstage.modules.system.entity.Department;
import com.littlebuddha.backstage.modules.system.entity.Menu;
import com.littlebuddha.backstage.modules.system.service.DepartmentService;
import com.littlebuddha.backstage.modules.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构数据帮助类
 *
 * @author ck
 * @date 2020/9/7 10:54
 */
@Service
public class TreeDataUtil {
    @Autowired
    private MenuService menuService;

    @Autowired
    private DepartmentService departmentService;

    /*树形结构数据排序
    @param sourceList 数据源集合
    @param targetList 排序后的集合
    @param parentId 当前的父级类目 ID*/
    public static List<Menu> sortList(List<Menu> sourceList, List<Menu> targetList, String parentId) {
        List<Menu> childrenList = null;
        for (Menu source : sourceList) {
            if (source.getParentId().equals(parentId)) {
                targetList.add(source);
                // 判断有没有子节点，有则继续追加
                if (source.getHasChildren() == 1) {
                    childrenList = new ArrayList<>();
                    //找子节点
                    for (Menu tbContentCategory : sourceList) {
                        if (tbContentCategory.getParentId().equals(source.getId())) {
                            sortList(sourceList, targetList, source.getId());
                            break;
                        }
                    }
                    source.setChildrenMenus(childrenList);
                }
            }
        }
        return targetList;
    }

    /**
     * 为menu设置子节点列表
     *
     * @param menuList
     * @return
     */
    public static List<Menu> setChildrenList(List<Menu> menuList) {
        Map<String, String> menuMap = new HashMap<>();
        //用于存放根节点
        Menu root = null;
        //便利列表
        for (Menu menu : menuList) {
            if ("0".equals(menu.getParentId())) {
                root = menu;
            }
            for (Menu menu1 : menuList) {
                if (menu.getParentId().equals(menu1.getId())) {
                    menu1.getChildrenMenus().add(menu);
                }
            }
        }
        //遍历菜单表，在map以id、name形式存放
        //便利列表，set进父节点
        return menuList;
    }

    /**
     * 为部门数据设置子节点列表
     *
     * @param departmentList
     * @return
     */
    public static List<Department> setDepartmentChildrenList(List<Department> departmentList) {
        Map<String, String> menuMap = new HashMap<>();
        //用于存放根节点
        Department root = null;
        //便利列表
        for (Department department : departmentList) {
            if ("0".equals(department.getParentId())) {
                root = department;
            }
            for (Department department1 : departmentList) {
                if (department.getParentId().equals(department1.getId())) {
                    department1.getChildrenList().add(department);
                }
            }
        }
        //遍历菜单表，在map以id、name形式存放
        //便利列表，set进父节点
        return departmentList;
    }
}
