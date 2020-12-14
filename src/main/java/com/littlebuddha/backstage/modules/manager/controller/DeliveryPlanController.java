package com.littlebuddha.backstage.modules.manager.controller;

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
}
