package com.littlebuddha.backstage.system.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.system.entity.Department;
import com.littlebuddha.backstage.system.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理controller类
 *
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/system/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute
    public Department get(@RequestParam(name = "id",required = false) String id){
        Department department = null;
        if(StringUtils.isBlank(id)){
            department = new Department();
        }
        if(department != null){
            department = departmentService.get(id);
        }
        return department;
    }

    @GetMapping(value = {"/list", ""})
    public String list() {
        return "system/department";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<List<Department>> findAll(Department department) {
        List<Department> all = departmentService.findAllList(department);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("ok");
        jsonResult.setCount(all.size());
        jsonResult.setData(all);
        return jsonResult;
    }

    /**
     * 隐藏域中传送一个parentId
     *
     * @param department
     * @param mode
     * @param model
     * @return
     */
    @GetMapping("/form/{mode}")
    public String form(Department department, @PathVariable(name = "mode") String mode, Model model) {
        model.addAttribute("mode", mode);
        model.addAttribute("department", department);
        return "system/departmentForm";
    }

    @ResponseBody
    @PostMapping("/save")
    public JsonResult save(String name,String type,String status) {
        //departmentService.save(department);
        System.out.println("检验传值name"+name);
        System.out.println("检验传值type"+type);
        System.out.println("检验传值status"+status);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("保存成功！！！");
        return jsonResult;
    }

    @ResponseBody
    @PostMapping("/delete")
    public JsonResult delete(Department department) {
        departmentService.deleteByPhysics(department);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("删除成功！！！");
        return jsonResult;
    }

    @ResponseBody
    @PostMapping("/deleteAll")
    public JsonResult deleteAll(String ids) {
        String idArray[] =ids.split(",");
        for (String id : idArray) {
            departmentService.deleteByPhysics(departmentService.get(id));
        }
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("删除成功！！！");
        return jsonResult;
    }
}
