package com.littlebuddha.backstage.common.utils.resultresponse;

/**
 * 当返回树状结构json数据时的实体类
 * @author ck
 * @date 2020/9/29 15:16
 */
public class JsonResult<D> {

    private boolean success = true;// 是否成功
    private String errorCode = "-1";//错误代码
    private Integer code;
    private String msg;
    private Integer count;
    private D data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

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
