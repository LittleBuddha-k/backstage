package com.littlebuddha.backstage.modules.manager.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.BalanceDetails;
import com.littlebuddha.backstage.modules.manager.service.BalanceDetailsService;
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
    @GetMapping("/data")
    public JsonResult<BalanceDetails> data(BalanceDetails balanceDetails){
        JsonResult result = new JsonResult();
        List<BalanceDetails> list = balanceDetailsService.findList(balanceDetails);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
