package com.littlebuddha.backstage.modules.manager.controller;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.MaterielReturnFromManufacturer;
import com.littlebuddha.backstage.modules.manager.service.MaterielReturnFromManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 厂商退料控制层
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/materielReturnFromManufacturer")
public class MaterielReturnFromManufacturerController {

    @Autowired
    private MaterielReturnFromManufacturerService materielReturnFromManufacturerService;

    @GetMapping(value = {"","/list"})
    public String list(MaterielReturnFromManufacturer materielReturnFromManufacturer, Model model){
        model.addAttribute("materielReturnFromManufacturer",materielReturnFromManufacturer);
        return "manager/materielReturnFromManufacturer";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<MaterielReturnFromManufacturer> data(MaterielReturnFromManufacturer materielReturnFromManufacturer){
        JsonResult result = new JsonResult();
        List<MaterielReturnFromManufacturer> list = materielReturnFromManufacturerService.findList(materielReturnFromManufacturer);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(MaterielReturnFromManufacturer materielReturnFromManufacturer, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("materielReturnFromManufacturer",materielReturnFromManufacturer);
        model.addAttribute("mode",mode);
        return "manager/form/materielReturnFromManufacturerForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(MaterielReturnFromManufacturer materielReturnFromManufacturer, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "厂商退料"+".xlsx";
            List<MaterielReturnFromManufacturer> list = materielReturnFromManufacturerService.findList(materielReturnFromManufacturer);
            new ExportExcel("厂商退料", MaterielReturnFromManufacturer.class).setDataList(list).write(response, fileName).dispose();
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
            List<MaterielReturnFromManufacturer> dataList = importExcel.getDataList(MaterielReturnFromManufacturer.class);
            for (MaterielReturnFromManufacturer materielReturnFromManufacturer : dataList) {
                System.out.println(materielReturnFromManufacturer);
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
            String fileName = "厂商退料导入模板.xlsx";
            List<MaterielReturnFromManufacturer> list = Lists.newArrayList();
            new ExportExcel("厂商退料", MaterielReturnFromManufacturer.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
