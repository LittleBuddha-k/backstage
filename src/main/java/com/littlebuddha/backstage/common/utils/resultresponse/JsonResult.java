package com.littlebuddha.backstage.common.utils.resultresponse;

/**
 * 当返回树状结构json数据时的实体类
 * @author ck
 * @date 2020/9/29 15:16
 */
public class JsonResult<D> {

    private Integer code;
    private String msg;
    private Integer count;
    private D data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
