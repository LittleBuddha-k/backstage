package com.littlebuddha.backstage.modules.manager.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.manager.entity.SummaryConsiderBomDetails;
import com.littlebuddha.backstage.modules.manager.service.SummaryConsiderBomDetailsService;
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
@RequestMapping("/manager/summaryConsiderBomDetails")
public class SummaryConsiderBomController {

    @Autowired
    private SummaryConsiderBomDetailsService summaryConsiderBomDetailsService;

    @GetMapping(value = {"","/list"})
    public String list(SummaryConsiderBomDetails summaryConsiderBomDetails, Model model){
        model.addAttribute("summaryConsiderBomDetails",summaryConsiderBomDetails);
        return "manager/summaryConsiderBom";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<SummaryConsiderBomDetails> data(SummaryConsiderBomDetails summaryConsiderBomDetails){
        JsonResult result = new JsonResult();
        List<SummaryConsiderBomDetails> list = summaryConsiderBomDetailsService.findList(summaryConsiderBomDetails);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
