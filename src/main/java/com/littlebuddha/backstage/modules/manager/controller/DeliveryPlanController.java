package com.littlebuddha.backstage.modules.manager.controller;

import com.littlebuddha.backstage.common.utils.DateUtils;
import com.littlebuddha.backstage.common.utils.excel.ExportExcel;
import com.littlebuddha.backstage.common.utils.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.io.FileUtil;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.DeliveryPlan;
import com.littlebuddha.backstage.modules.manager.service.DeliveryPlanService;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 导出excel文件
     */
    @ResponseBody
    @RequestMapping(value = "export")
    public void templateExport(DeliveryPlan deliveryPlan, HttpServletRequest request, HttpServletResponse response) {
        try {
            //模板路径
            String templatepath = request.getServletContext().getRealPath("/template/deliveryPlan.xlsx");
            //excel临时存放路径
            String realpath = request.getServletContext().getRealPath("/template/real");//压缩文件集合
            File savedir = new File(realpath);
            if(!savedir.exists()){
                savedir.mkdirs();
            }
            List<DeliveryPlan> list = deliveryPlanService.findList(deliveryPlan);
            String fileName = "终端信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";// 导出文件名
            String filepath = realpath + File.separator + fileName;
            OutputStream os = new FileOutputStream(filepath);
            InputStream is = new FileInputStream(templatepath);
            XLSTransformer transformer = new XLSTransformer();
            Map beans = new HashMap();
            beans.put("list",list);
            XSSFWorkbook workbook = (XSSFWorkbook) transformer.transformXLS(is,beans);
            workbook.write(os);
            //关闭excel输出流
            os.close();
            is.close();
            FileUtil.downloadFile(response,realpath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excel文件
     */
    @ResponseBody
    @RequiresPermissions("marketing:visiting:export")
    @RequestMapping(value = "export")
    public JsonResult annotationExport(DeliveryPlan visiting, HttpServletRequest request, HttpServletResponse response) {
        JsonResult j = new JsonResult();
        try {
            String fileName = "访店信息" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            List<DeliveryPlan> exportData = deliveryPlanService.findList(visiting);
            new ExportExcel("访店信息", DeliveryPlan.class).setDataList(exportData).write(response, fileName).dispose();
            j.setMsg("导出成功！");
            return j;
        } catch (Exception e) {
            j.setMsg("导出访店信息失败！失败信息：" + e.getMessage());
        }
        return j;
    }

    /**
     * 导入Excel数据
     */
    @ResponseBody
    @RequestMapping(value = "import")
    public JsonResult templateImport(@RequestParam("file")MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
        JsonResult j = new JsonResult();
        try {
            int successNum = 0;
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<DeliveryPlan> list = ei.getDataList(DeliveryPlan.class);
            for (DeliveryPlan deliveryPlan : list){
                try{
                    deliveryPlanService.save(deliveryPlan);
                    successNum++;
                }catch (Exception ex) {
                    failureNum++;
                }
            }
            if (failureNum>0){
                failureMsg.insert(0, "，失败 "+failureNum+" 条终端信息管理记录。");
            }
            j.setMsg( "已成功导入 "+successNum+" 条终端信息管理"+failureMsg);
        } catch (Exception e) {
            j.setMsg("导入终端信息管理失败！失败信息："+e.getMessage());
        }
        return j;
    }

    /**
     * 下载导入终端信息数据模板
     */
    @ResponseBody
    @RequestMapping(value = "import/template")
    public JsonResult exportTemplate(HttpServletResponse response) {
        JsonResult j = new JsonResult();
        try {
            String fileName = "终端信息导入模板.xlsx";
            List<DeliveryPlan> list = new ArrayList<>();
            new ExportExcel("终端信息数据", DeliveryPlan.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            j.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return j;
    }
}
