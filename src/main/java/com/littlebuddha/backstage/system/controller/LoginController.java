package com.littlebuddha.backstage.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ck
 * @date 2020/9/21 15:01
 */
@Controller
public class LoginController {

    @GetMapping("/add")
    public String add(){
        return "settings/add";
    }

    @GetMapping("/edit")
    public String edit(){
        return "settings/edit";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "system/login";
    }
}
