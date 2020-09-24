package com.littlebuddha.backstage.system.controller;

import com.littlebuddha.backstage.common.base.Page;
import com.littlebuddha.backstage.system.entity.Menu;
import com.littlebuddha.backstage.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * findPage被重写  对list进行了排序，与赋予子节点列表
     * @param page
     * @param menu
     * @return
     */
    @ResponseBody
    @GetMapping("/data")
    public Page<Menu> data(Page<Menu> page,Menu menu){
        return menuService.findPage(page,menu);
    }

    @ResponseBody
    @GetMapping("/levelOneMenus")
    public List<Menu> levelOneMenus(){
        List<Menu> levelOneMenus = menuService.findLevelOneMenus();
        return levelOneMenus;
    }

    @ResponseBody
    @GetMapping("/getChildren")
    public List<Menu> getChildren(Menu parentMenu){
        List<Menu> childrenMenus = menuService.getChildren(parentMenu);
        return childrenMenus;
    }
}
