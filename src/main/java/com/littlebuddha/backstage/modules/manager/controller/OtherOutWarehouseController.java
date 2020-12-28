package com.littlebuddha.backstage.modules.manager.controller;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.OtherOutWarehouse;
import com.littlebuddha.backstage.modules.manager.service.OtherOutWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 其他出库控制层
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/otherOutWarehouse")
public class OtherOutWarehouseController {

    @Autowired
    private OtherOutWarehouseService otherOutWarehouseService;

    @GetMapping(value = {"","/list"})
    public String list(OtherOutWarehouse otherOutWarehouse, Model model){
        model.addAttribute("otherOutWarehouse",otherOutWarehouse);
        return "manager/otherOutWarehouse";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<OtherOutWarehouse> data(OtherOutWarehouse otherOutWarehouse){
        JsonResult result = new JsonResult();
        List<OtherOutWarehouse> list = otherOutWarehouseService.findList(otherOutWarehouse);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(OtherOutWarehouse otherOutWarehouse, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("otherOutWarehouse",otherOutWarehouse);
        model.addAttribute("mode",mode);
        return "manager/form/otherOutWarehouseForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(OtherOutWarehouse otherOutWarehouse, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "其他出库信息"+".xlsx";
            List<OtherOutWarehouse> list = otherOutWarehouseService.findList(otherOutWarehouse);
            new ExportExcel("其他出库信息", OtherOutWarehouse.class).setDataList(list).write(response, fileName).dispose();
            jsonResult.setMsg("导出成功！");
            return jsonResult;
        } catch (Exception e) {
            jsonResult.setMsg("导出其他出库信息记录失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }

    @ResponseBody
    @PostMapping("/import")
    public JsonResult importFile(@RequestParam(name = "file") MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        try {
            ImportExcel importExcel = new ImportExcel(file,1,0);
            List<OtherOutWarehouse> dataList = importExcel.getDataList(OtherOutWarehouse.class);
            for (OtherOutWarehouse otherOutWarehouse : dataList) {
                System.out.println(otherOutWarehouse);
            }
        } catch (Exception e) {
            jsonResult.setCode(400);
            jsonResult.setMsg("导入失败。。。。。。");
        }
        return jsonResult;
    }

    /**
     * 下载导入终端信息数据模板
     */
    @ResponseBody
    @RequestMapping(value = "import/template")
    public JsonResult importFileTemplate(HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "其他出库导入模板.xlsx";
            List<OtherOutWarehouse> list = Lists.newArrayList();
            new ExportExcel("其他出库数据", OtherOutWarehouse.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
