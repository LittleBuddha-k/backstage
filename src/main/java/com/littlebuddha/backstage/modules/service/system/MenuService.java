package com.littlebuddha.backstage.modules.service.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.littlebuddha.backstage.common.utils.TreeDataUtil;
import com.littlebuddha.backstage.modules.base.CrudService;
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
        List<Menu> sortList = TreeDataUtil.sortList(beforeSort, afterSort, "-1");//将数据从级别最高的到最小分组来排序
        List<Menu> setChildrenList = TreeDataUtil.setChildrenList(sortList);//为有子节的menu设置子数据
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(setChildrenList);
        return pageInfo;
    }

    @Override
    public int save(Menu entity) {
        return super.save(entity);
    }

    @Override
    public int deleteByPhysics(Menu entity) {
        return super.deleteByPhysics(entity);
    }

    @Override
    public int deleteByLogic(Menu entity) {
        return super.deleteByLogic(entity);
    }

    @Override
    public void recovery(Menu entity) {
        super.recovery(entity);
    }
}
