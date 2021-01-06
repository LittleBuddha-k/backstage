package com.littlebuddha.backstage.modules.manager.controller;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.FinishedDeliveryDetails;
import com.littlebuddha.backstage.modules.manager.service.FinishedDeliveryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 成品出库明细控制层
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/finishedDeliveryDetails")
public class FinishedDeliveryDetailsController {

    @Autowired
    private FinishedDeliveryDetailsService finishedDeliveryDetailsService;

    @GetMapping(value = {"","/list"})
    public String list(FinishedDeliveryDetails finishedDeliveryDetails, Model model){
        model.addAttribute("finishedDeliveryDetails",finishedDeliveryDetails);
        return "manager/finishedDeliveryDetails";
    }

    @ResponseBody
    @PostMapping("/data")
    public JsonResult<FinishedDeliveryDetails> data(FinishedDeliveryDetails finishedDeliveryDetails){
        JsonResult result = new JsonResult();
        List<FinishedDeliveryDetails> list = finishedDeliveryDetailsService.findList(finishedDeliveryDetails);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(FinishedDeliveryDetails finishedDeliveryDetails, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("finishedDeliveryDetails",finishedDeliveryDetails);
        model.addAttribute("mode",mode);
        return "manager/form/finishedDeliveryDetailsForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(FinishedDeliveryDetails finishedDeliveryDetails, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "成品出库明细"+".xlsx";
            List<FinishedDeliveryDetails> list = finishedDeliveryDetailsService.findList(finishedDeliveryDetails);
            new ExportExcel("成品出库明细", FinishedDeliveryDetails.class).setDataList(list).write(response, fileName).dispose();
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
            List<FinishedDeliveryDetails> dataList = importExcel.getDataList(FinishedDeliveryDetails.class);
            for (FinishedDeliveryDetails finishedDeliveryDetails : dataList) {
                finishedDeliveryDetailsService.save(finishedDeliveryDetails);
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
            String fileName = "成品出库明细导入模板.xlsx";
            List<FinishedDeliveryDetails> list = Lists.newArrayList();
            new ExportExcel("成品出库明细", FinishedDeliveryDetails.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
