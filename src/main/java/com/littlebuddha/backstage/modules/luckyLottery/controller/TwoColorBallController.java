package com.littlebuddha.backstage.modules.luckyLottery.controller;

import com.google.common.collect.Lists;
import com.littlebuddha.backstage.common.excel.ExportExcel;
import com.littlebuddha.backstage.common.excel.ImportExcel;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;
import com.littlebuddha.backstage.modules.base.BaseController;
import com.littlebuddha.backstage.modules.base.Page;
import com.littlebuddha.backstage.modules.luckyLottery.entity.TwoColorBall;
import com.littlebuddha.backstage.modules.luckyLottery.service.TwoColorBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 福彩雙色球控制層
 * @author ck
 * @date 2021/1/13 9:58
 */
@Controller
@RequestMapping("/luckyLottery/twoColorBall")
public class TwoColorBallController extends BaseController {

    @Autowired
    private TwoColorBallService twoColorBallService;

    /**
     * 復現歷史中獎號碼
     * @param twoColorBall
     * @param model
     * @return
     */
    @GetMapping(value = {"","/list"})
    public String list(TwoColorBall twoColorBall, Model model){
        model.addAttribute("twoColorBall",twoColorBall);
        return "luckyLottery/twoColorBall";
    }

    @ResponseBody
    @PostMapping("/data")
    public JsonResult data(TwoColorBall twoColorBall, HttpServletRequest request,HttpServletResponse response){
        Page<TwoColorBall> page = twoColorBallService.findPage(new Page<TwoColorBall>(), twoColorBall);
        return getLayUiData(page);
    }

    @ResponseBody
    @PostMapping("/import")
    public JsonResult importFile(@RequestParam(name = "file")MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        try {
            ImportExcel importExcel = new ImportExcel(file,1,0);
            List<TwoColorBall> dataList = importExcel.getDataList(TwoColorBall.class);
            for (TwoColorBall twoColorBall : dataList) {
                twoColorBallService.save(twoColorBall);
            }
        } catch (Exception e) {
            jsonResult.setCode(400);
            jsonResult.setMsg("导入失败。。。。。。");
        }
        return jsonResult;
    }

    /**
     * 下载导入终端信息数据模板
     */
    @ResponseBody
    @RequestMapping(value = "import/template")
    public JsonResult importFileTemplate(HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();
        try {
            String fileName = "双色球导入模板.xlsx";
            List<TwoColorBall> list = Lists.newArrayList();
            new ExportExcel("双色球数据", TwoColorBall.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            jsonResult.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
        }
        return jsonResult;
    }
}
