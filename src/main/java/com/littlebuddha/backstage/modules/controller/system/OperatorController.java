package com.littlebuddha.backstage.modules.controller.system;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.entity.system.Operator;
import com.littlebuddha.backstage.modules.service.system.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system/operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @GetMapping(value = {"","/list"})
    public String list(Operator operator, Model model){
        model.addAttribute("operator",operator);
        return "system/operator";
    }

    @ResponseBody
    @RequestMapping("/data")
    public JsonResult data(Operator operator){
        JsonResult jsonResult = new JsonResult();
        List<Operator> list = operatorService.findList(operator);
        jsonResult.setCode(0);
        jsonResult.setMsg("成功");
        jsonResult.setData(list);
        return jsonResult;
    }

    @GetMapping("/form/{mode}")
    public String form(@PathVariable(name = "mode")String mode,Operator operator,Model model){
        model.addAttribute("mode",mode);
        model.addAttribute("operator",operator);
        return "system/form/operatorForm";
    }
}
