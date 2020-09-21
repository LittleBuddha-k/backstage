package com.littlebuddha.backstage.system.controller;

import com.littlebuddha.backstage.system.entity.Area;
import com.littlebuddha.backstage.system.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 区域管理controller类
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/system/area")
public class AreaController {

    @Autowired
    private AreaMapper areaMapper;

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Area> findAll(){
        return areaMapper.findAll(new Area());
    }
}
