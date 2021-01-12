package com.littlebuddha.backstage.modules.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ck
 * @date 2020/12/9 15:00
 */
@Controller
@RequestMapping("/base")
public class ImportHtml {

    @GetMapping("/importHtml")
    public String importHtml(){

        return "base/importHtml";
    }
}
