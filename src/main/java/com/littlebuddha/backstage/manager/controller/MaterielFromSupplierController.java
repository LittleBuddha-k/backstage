package com.littlebuddha.backstage.manager.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.manager.entity.MaterielFromSupplier;
import com.littlebuddha.backstage.manager.service.MaterielFromSupplierService;
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
@RequestMapping("/manager/materielFromSupplier")
public class MaterielFromSupplierController {

    @Autowired
    private MaterielFromSupplierService materielFromSupplierService;

    @GetMapping(value = {"","/list"})
    public String list(MaterielFromSupplier materielFromSupplier, Model model){
        model.addAttribute("materielFromSupplier",materielFromSupplier);
        return "manager/materielFromSupplier";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<MaterielFromSupplier> data(MaterielFromSupplier materielFromSupplier){
        JsonResult result = new JsonResult();
        List<MaterielFromSupplier> list = materielFromSupplierService.findList(materielFromSupplier);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
