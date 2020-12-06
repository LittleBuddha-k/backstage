package com.littlebuddha.backstage.manager.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.manager.entity.MaterialReturnFromManufacturer;
import com.littlebuddha.backstage.manager.entity.OtherOutWarehouse;
import com.littlebuddha.backstage.manager.service.MaterielReturnFromManufacturerService;
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
@RequestMapping("/manager/materielReturnFromManufacturer")
public class MaterielReturnFromManufacturerController {

    @Autowired
    private MaterielReturnFromManufacturerService materielReturnFromManufacturerService;

    @GetMapping(value = {"","/list"})
    public String list(MaterialReturnFromManufacturer materielReturnFromManufacturer, Model model){
        model.addAttribute("materielReturnFromManufacturer",materielReturnFromManufacturer);
        return "manager/materielReturnFromManufacturer";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<MaterialReturnFromManufacturer> data(MaterialReturnFromManufacturer materielReturnFromManufacturer){
        JsonResult result = new JsonResult();
        List<MaterialReturnFromManufacturer> list = materielReturnFromManufacturerService.findList(materielReturnFromManufacturer);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
