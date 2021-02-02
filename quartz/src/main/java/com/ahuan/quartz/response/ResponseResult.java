package com.ahuan.quartz.response;

/**
 * 用户系统ajax的统一返回消息
 *
 * @author zhanghuan
 * @date 2019-02-28
 */

public class ResponseResult<T> {

    /**
     * 校验失败返回码
     */
    public static final String VALIDATE_STATUSCODE = "-2";
    public static final String SUCCEED_STATUSCODE = "0";
    /**
     * code
     */
    private String statusCode = "0";
    /**
     * 操作结果描述信息
     */
    private String statusInfo = "success";
    /**
     * 操作返回数据绑定
     */
    private T data;


    private Integer totalCount;


    private Object datas;


    private ResponseResult(String statusCode, String statusInfo) {
        this.statusCode = statusCode;
        this.statusInfo = statusInfo;
    }

    private ResponseResult(T data) {
        this.data = data;
    }

    private ResponseResult(String statusCode, String statusInfo, T data) {
        this.statusCode = statusCode;
        this.statusInfo = statusInfo;
        this.data = data;
    }

    private ResponseResult() {

    }

    private ResponseResult(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public static <T> ResponseResult<T> result(String code, String info) {
        return new ResponseResult<T>(code, info);
    }

    public static <T> ResponseResult<T> result(String code, String info, T data) {
        return new ResponseResult<T>(code, info, data);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(data);
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>();
    }

    public static <T> ResponseResult<T> success(Integer totalCount, Object datas) {
        ResponseResult<T> res = new ResponseResult<T>();
        res.setTotalCount(totalCount);
        res.setDatas(datas);
        return res;
    }


    public static <T> ResponseResult<T> defaultError() {
        ResponseResult<T> res = new ResponseResult<T>();
        res.statusCode = "-1";
        res.statusInfo = "UNKNOW ERROR";
        return res;
    }


    public static <T> ResponseResult<T> error(String info) {
        ResponseResult<T> res = new ResponseResult<T>(info);
        res.statusCode = "-1";
        res.statusInfo = info;
        return res;
    }

}