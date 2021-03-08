package com.littlebuddha.backstage.modules.controller.manager;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.entity.manager.Order;
import com.littlebuddha.backstage.modules.service.manager.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单控制层
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = {"","/list"})
    public String list(Order order, Model model){
        model.addAttribute("order",order);
        return "modules/manager/order";
    }

    @ResponseBody
    @PostMapping("/data")
    public JsonResult<Order> data(Order order,String materielNumber){
        System.out.println("接收到料号为"+order.getMaterielNumber());
        JsonResult result = new JsonResult();
        List<Order> list = orderService.findList(order);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }

    @GetMapping("/form/{mode}")
    public String form(Order order, @PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("order",order);
        model.addAttribute("mode",mode);
        return "modules/manager/form/orderForm";
    }

    @ResponseBody
    @RequestMapping("export")
    public JsonResult exportFile(Order order, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "订单信息"+".xlsx";
            List<Order> list = orderService.findList(order);
            new ExportExcel("订单信息", Order.class).setDataList(list).write(response, fileName).dispose();
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
            List<Order> dataList = importExcel.getDataList(Order.class);
            for (Order order : dataList) {
                orderService.save(order);
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
            String fileName = "订单导入模板.xlsx";
            List<Order> list = Lists.newArrayList();
            new ExportExcel("订单数据", Order.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
