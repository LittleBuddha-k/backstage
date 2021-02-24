package com.littlebuddha.backstage.modules.controller.manager;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.entity.manager.SummaryConsiderBomDetails;
import com.littlebuddha.backstage.modules.service.manager.SummaryConsiderBomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 只依bom明细的统计控制层
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/summaryConsiderBomDetails")
public class SummaryConsiderBomDetailsController {

    @Autowired
    private SummaryConsiderBomDetailsService summaryConsiderBomDetailsService;

    @GetMapping(value = {"","/list"})
    public String list(SummaryConsiderBomDetails summaryConsiderBomDetails, Model model){
        model.addAttribute("summaryConsiderBomDetails",summaryConsiderBomDetails);
        return "manager/summaryConsiderBomDetails";
    }

    @ResponseBody
    @PostMapping("/data")
    public JsonResult<SummaryConsiderBomDetails> data(SummaryConsiderBomDetails summaryConsiderBomDetails){
        JsonResult result = new JsonResult();
        List<SummaryConsiderBomDetails> list = summaryConsiderBomDetailsService.findList(summaryConsiderBomDetails);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(SummaryConsiderBomDetails summaryConsiderBomDetails, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("summaryConsiderBomDetails",summaryConsiderBomDetails);
        model.addAttribute("mode",mode);
        return "manager/form/summaryConsiderBomDetailsForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(SummaryConsiderBomDetails summaryConsiderBomDetails, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "只依bom明细的统计"+".xlsx";
            List<SummaryConsiderBomDetails> list = summaryConsiderBomDetailsService.findList(summaryConsiderBomDetails);
            new ExportExcel("只依bom明细的统计", SummaryConsiderBomDetails.class).setDataList(list).write(response, fileName).dispose();
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
            List<SummaryConsiderBomDetails> dataList = importExcel.getDataList(SummaryConsiderBomDetails.class);
            for (SummaryConsiderBomDetails summaryConsiderBomDetails : dataList) {
                summaryConsiderBomDetailsService.save(summaryConsiderBomDetails);
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
            String fileName = "只依bom明细的统计导入模板.xlsx";
            List<SummaryConsiderBomDetails> list = Lists.newArrayList();
            new ExportExcel("只依bom明细的统计", SummaryConsiderBomDetails.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
