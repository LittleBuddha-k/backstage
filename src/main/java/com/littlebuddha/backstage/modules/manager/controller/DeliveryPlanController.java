package com.littlebuddha.backstage.modules.manager.controller;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.DeliveryPlan;
import com.littlebuddha.backstage.modules.manager.service.DeliveryPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/deliveryPlan")
public class DeliveryPlanController {

    @Autowired
    private DeliveryPlanService deliveryPlanService;

    @GetMapping(value = {"", "/list"})
    public String list(DeliveryPlan deliveryPlan, Model model) {
        model.addAttribute("deliveryPlan", deliveryPlan);
        return "manager/deliveryPlan";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<DeliveryPlan> data(DeliveryPlan deliveryPlan, String materielNumber) {
        JsonResult result = new JsonResult();
        List<DeliveryPlan> list = deliveryPlanService.findList(deliveryPlan);
        List<DeliveryPlan> all = deliveryPlanService.findList(new DeliveryPlan());
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(all.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(DeliveryPlan deliveryPlan,@PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("deliveryPlan",deliveryPlan);
        model.addAttribute("mode",mode);
        return "manager/form/deliveryPlanForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(DeliveryPlan deliveryPlan,HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "交货计划信息"+".xlsx";
            List<DeliveryPlan> list = deliveryPlanService.findList(deliveryPlan);
            new ExportExcel("交货计划信息", DeliveryPlan.class).setDataList(list).write(response, fileName).dispose();
        } catch (Exception e) {
            jsonResult.setSuccess(false);
            jsonResult.setMsg("导出订单信息记录失败！失败信息："+e.getMessage());
            return jsonResult;
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/import")
    public JsonResult importFile(@RequestParam(name = "file")MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        try {
            ImportExcel importExcel = new ImportExcel(file,1,0);
            List<DeliveryPlan> dataList = importExcel.getDataList(DeliveryPlan.class);
            for (DeliveryPlan deliveryPlan : dataList) {
                System.out.println(deliveryPlan);
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
            String fileName = "交货计划导入模板.xlsx";
            List<DeliveryPlan> list = Lists.newArrayList();
            new ExportExcel("交货计划数据", DeliveryPlan.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
