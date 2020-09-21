package com.littlebuddha.backstage.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ck
 * @date 2020/9/14 14:12
 */
@Controller
public class SpringBootHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String bootHello(){
        return "hello!!!";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
