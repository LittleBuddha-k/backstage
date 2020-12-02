package com.littlebuddha.backstage.datastatistics.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.datastatistics.entity.Materiel;
import com.littlebuddha.backstage.datastatistics.service.MaterielService;
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
@RequestMapping("/dataStatistics/materiel")
public class MaterielController {

    @Autowired
    private MaterielService materielService;

    @GetMapping(value = {"","/list"})
    public String list(Materiel materiel, Model model){
        model.addAttribute("materiel",materiel);
        return "dataStatistics/materiel";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<Materiel> data(Materiel materiel){
        JsonResult result = new JsonResult();
        List<Materiel> list = materielService.findList(materiel);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
