package com.littlebuddha.backstage.system.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.system.entity.Department;
import com.littlebuddha.backstage.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门管理controller类
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/system/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @GetMapping("/findAllList")
    public JsonResult<List<Department>> findAll(Department department){
        List<Department> all = departmentService.findAllList(department);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("ok");
        jsonResult.setCount(all.size());
        jsonResult.setData(all);
        return jsonResult;
    }
}
