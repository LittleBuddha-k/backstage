package com.littlebuddha.backstage.modules.service.system;

import com.github.pagehelper.PageInfo;
import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.base.Page;
import com.littlebuddha.backstage.common.utils.TreeDataUtil;
import com.littlebuddha.backstage.modules.entity.system.Menu;
import com.littlebuddha.backstage.modules.mapper.system.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService extends CrudService<Menu, MenuMapper> {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public PageInfo<Menu> findPage(Page<Menu> page, Menu entity) {
        List<Menu> beforeSort = super.findList(entity);
        List<Menu> afterSort = new ArrayList<>();
        List<Menu> sortList = TreeDataUtil.sortList(beforeSort, afterSort, "0");//将数据从级别最高的到最小分组来排序
        List<Menu> setChildrenList = TreeDataUtil.setChildrenList(sortList);//为有子节的menu设置子数据
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(setChildrenList);
        return pageInfo;
    }

    /**
     * 查询菜单中级别最高的那个菜单
     * @return
     */
    public Menu findTheBiggestMenu(){
        List<Menu> allMenus = super.findAllList(new Menu());
        Menu theBiggestMenu = new Menu();
        for (Menu menu : allMenus) {
            if (menu.getParentId() == "0" || "0".equals(menu.getParentId())){
                theBiggestMenu = menu;
                break;
            }
        }
        return theBiggestMenu;
    }

    /**
     * 通过父类id查询其子节点的菜单列表
     * @return
     */
    public List<Menu> findByParentId(Menu menu){
        List<Menu> menus = menuMapper.findByParentId(menu);
        return menus;
    }

    /**
     * 查找一级菜单
     * @return
     */
    public List<Menu> findLevelOneMenus() {
        Menu theBiggestMenu = findTheBiggestMenu();
        List<Menu> levelOneMenus = findByParentId(theBiggestMenu);
        return levelOneMenus;
    }

    /**
     * 查找子节点列表
     * @param parentMenu
     * @return
     */
    public List<Menu> getChildren(Menu parentMenu) {
        List<Menu> childrenMenus = menuMapper.findByParentId(parentMenu);
        return childrenMenus;
    }
}
