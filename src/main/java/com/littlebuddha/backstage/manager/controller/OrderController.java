package com.littlebuddha.backstage.manager.controller;

import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.manager.entity.Order;
import com.littlebuddha.backstage.manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:06
 */
@Controller
@RequestMapping("/manager/order")
public class OrderController {

    @Autowired
    private OrderService materielService;

    @GetMapping(value = {"","/list"})
    public String list(Order order, Model model){
        model.addAttribute("order",order);
        return "manager/order";
    }

    @ResponseBody
    @GetMapping("/data")
    public JsonResult<Order> data(Order order,String materielNumber){
        System.out.println("接收到料号为"+order.getMaterielNumber());
        JsonResult result = new JsonResult();
        List<Order> list = materielService.findList(order);
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
}
