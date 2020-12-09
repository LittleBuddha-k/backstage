package com.littlebuddha.backstage.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ck
 * @date 2020/12/9 15:00
 */
@Controller
public class ImportHtml {

    @GetMapping("/importHtml")
    public String importHtml(){

        return "common/importHtml";
    }
}
