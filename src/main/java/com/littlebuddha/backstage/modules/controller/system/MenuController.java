package com.littlebuddha.backstage.modules.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.base.BaseController;
import com.littlebuddha.backstage.modules.entity.system.Menu;
import com.littlebuddha.backstage.modules.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = {"", "/list"})
    public String list(Menu menu, Model model) {
        model.addAttribute("menu", menu);
        return "system/menu";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<Menu> data(Menu menu) {
        PageInfo<Menu> page = menuService.findPage(new Page<Menu>(), menu);
        JsonResult layUiData = getLayUiData(page);
        return layUiData;
    }

    @GetMapping("/form/{mode}")
    public String form(Menu menu, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("menu",menu);
        model.addAttribute("mode",mode);
        return "system/form/menuForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(Menu Menu, HttpServletResponse response){

        return null;
    }

    @ResponseBody
    @PostMapping("/import")
    public JsonResult importFile(@RequestParam(name = "file") MultipartFile file){

        return null;
    }

    /**
     * 下载导入终端信息数据模板
     */
    @ResponseBody
    @RequestMapping(value = "import/template")
    public JsonResult importFileTemplate(HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "交货计划导入模板.xlsx";
            List<Menu> list = Lists.newArrayList();
            new ExportExcel("交货计划数据", Menu.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
