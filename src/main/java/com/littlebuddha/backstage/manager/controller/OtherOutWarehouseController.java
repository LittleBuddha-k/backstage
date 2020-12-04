package com.littlebuddha.backstage.manager.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.manager.entity.OtherOutWarehouse;
import com.littlebuddha.backstage.manager.service.OtherOutWarehouseService;
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
@RequestMapping("/manager/otherOutWarehouse")
public class OtherOutWarehouseController {

    @Autowired
    private OtherOutWarehouseService otherOutWarehouseService;

    @GetMapping(value = {"","/list"})
    public String list(OtherOutWarehouse otherOutWarehouse, Model model){
        model.addAttribute("otherOutWarehouse",otherOutWarehouse);
        return "manager/otherOutWarehouse";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<OtherOutWarehouse> data(OtherOutWarehouse otherOutWarehouse){
        JsonResult result = new JsonResult();
        List<OtherOutWarehouse> list = otherOutWarehouseService.findList(otherOutWarehouse);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
