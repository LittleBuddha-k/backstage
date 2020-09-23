package com.littlebuddha.backstage.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ck
 * @date 2020/9/21 15:01
 */
@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage() {
        return "system/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        System.out.println("开始login");
        System.out.println("密码："+password);
        System.out.println("用户："+username);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("message", "账户错误");
            return "redirect:/loginPage";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("message", "密码错误");
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/logOut")
    public String logOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/logOut";
    }
}
