package com.littlebuddha.backstage.modules.base;

import com.github.pagehelper.PageInfo;
import com.littlebuddha.backstage.common.utils.resultresponse.JsonResult;

import java.util.List;

/**
 * @author ck
 * @date 2021/2/24 14:43
 */
public abstract class BaseController {

    public<T> JsonResult getLayUiData(PageInfo pageInfo){
        List data = pageInfo.getList();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("成功");
        jsonResult.setData(data);
        jsonResult.setCount(pageInfo.getPages());
        return jsonResult;
    }
}
