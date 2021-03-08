package com.littlebuddha.backstage.modules.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ck
 * @date 2020/9/21 15:15
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/index"})
    public String index(){

        return "modules/system/index";
    }
}
