package com.littlebuddha.backstage.modules.manager.controller;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.MaterielFromSupplier;
import com.littlebuddha.backstage.modules.manager.service.MaterielFromSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 厂商来料控制层
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/materielFromSupplier")
public class MaterielFromSupplierController {

    @Autowired
    private MaterielFromSupplierService materielFromSupplierService;

    @GetMapping(value = {"","/list"})
    public String list(MaterielFromSupplier materielFromSupplier, Model model){
        model.addAttribute("materielFromSupplier",materielFromSupplier);
        return "manager/materielFromSupplier";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<MaterielFromSupplier> data(MaterielFromSupplier materielFromSupplier){
        JsonResult result = new JsonResult();
        List<MaterielFromSupplier> list = materielFromSupplierService.findList(materielFromSupplier);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(MaterielFromSupplier materielFromSupplier, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("materielFromSupplier",materielFromSupplier);
        model.addAttribute("mode",mode);
        return "manager/form/materielFromSupplierForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(MaterielFromSupplier materielFromSupplier, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "厂商来料"+".xlsx";
            List<MaterielFromSupplier> list = materielFromSupplierService.findList(materielFromSupplier);
            new ExportExcel("厂商来料", MaterielFromSupplier.class).setDataList(list).write(response, fileName).dispose();
        } catch (Exception e) {
            jsonResult.setSuccess(false);
            jsonResult.setMsg("导出订单信息记录失败！失败信息："+e.getMessage());
            return jsonResult;
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/import")
    public JsonResult importFile(@RequestParam(name = "file") MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        try {
            ImportExcel importExcel = new ImportExcel(file,1,0);
            List<MaterielFromSupplier> dataList = importExcel.getDataList(MaterielFromSupplier.class);
            for (MaterielFromSupplier materielFromSupplier : dataList) {
                System.out.println(materielFromSupplier);
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
            String fileName = "厂商来料导入模板.xlsx";
            List<MaterielFromSupplier> list = Lists.newArrayList();
            new ExportExcel("厂商来料", MaterielFromSupplier.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
