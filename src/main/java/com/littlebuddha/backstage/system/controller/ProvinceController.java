package com.littlebuddha.backstage.system.controller;

import com.littlebuddha.backstage.system.entity.Province;
import com.littlebuddha.backstage.system.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 区域管理controller类
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/system/province")
public class ProvinceController {

    @Autowired
    private ProvinceMapper provinceMapper;

    @ResponseBody
    @GetMapping("/findAll")
    public List<Province> findAll(){
        List<Province> all = provinceMapper.findAll();
        return all;
    }
}
