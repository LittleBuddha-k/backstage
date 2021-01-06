package com.littlebuddha.backstage.modules.manager.controller;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.BalanceDetails;
import com.littlebuddha.backstage.modules.manager.service.BalanceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 赛达信组装盘点汇总表控制层
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/balanceDetails")
public class BalanceDetailsController {

    @Autowired
    private BalanceDetailsService balanceDetailsService;

    @GetMapping(value = {"","/list"})
    public String list(BalanceDetails balanceDetails, Model model){
        model.addAttribute("balanceDetails",balanceDetails);
        return "manager/balanceDetails";
    }

    @ResponseBody
    @PostMapping("/data")
    public JsonResult<BalanceDetails> data(BalanceDetails balanceDetails){
        JsonResult result = new JsonResult();
        List<BalanceDetails> list = balanceDetailsService.findList(balanceDetails);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(BalanceDetails balanceDetails, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("balanceDetails",balanceDetails);
        model.addAttribute("mode",mode);
        return "manager/form/balanceDetailsForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(BalanceDetails balanceDetails, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "赛达信组装盘点汇总表"+".xlsx";
            List<BalanceDetails> list = balanceDetailsService.findList(balanceDetails);
            new ExportExcel("赛达信组装盘点汇总表", BalanceDetails.class).setDataList(list).write(response, fileName).dispose();
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
            List<BalanceDetails> dataList = importExcel.getDataList(BalanceDetails.class);
            for (BalanceDetails balanceDetails : dataList) {
                balanceDetailsService.save(balanceDetails);
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
            String fileName = "赛达信组装盘点汇总表导入模板.xlsx";
            List<BalanceDetails> list = Lists.newArrayList();
            new ExportExcel("赛达信组装盘点汇总表", BalanceDetails.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
