package com.littlebuddha.backstage.modules.manager.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.FinishedDeliveryDetails;
import com.littlebuddha.backstage.modules.manager.service.FinishedDeliveryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
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
    @GetMapping("/data")
    public JsonResult<FinishedDeliveryDetails> data(FinishedDeliveryDetails finishedDeliveryDetails){
        JsonResult result = new JsonResult();
        List<FinishedDeliveryDetails> list = finishedDeliveryDetailsService.findList(finishedDeliveryDetails);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
