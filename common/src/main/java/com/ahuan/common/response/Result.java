package com.ahuan.common.response;

import java.io.Serializable;

/**
 * @program: springcloud
 * @description: 统一数据结构
 * @author: ahuan
 * @version: 2021-01-09 18:04
 **/
public class Result<T> implements Serializable {
    public static  final  String SUCCESS="0";
    public static  final  String FAILED="-1";
    public static  final  String SUCCESS_MESG="SUCCESS";
    private String code;
    private String mesg;
    private T data;

    public static <T> Result<T> ok(T data) {
        return  new Result(data);
    }
    public static <T> Result<T> ok(String code,T data) {
        return  new Result(code,data);
    }
    public static <T> Result<T> ok(String code,String mesg,T data) {
        return  new Result(code,mesg,data);
    }

    public static <T> Result<T> error(String code,String mesg) {
        return  new Result(code,mesg);
    }

    public static <T> Result<T> error(String mesg) {
        return  new Result(mesg);
    }

    private Result() {

    }

    private Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
    }

    private Result(String code, String mesg) {
        this(code,mesg,null);
    }
    private Result( String mesg) {
        this(FAILED,mesg,null);
    }
    private Result(T data) {
        this(SUCCESS,SUCCESS_MESG,data);
    }
    private Result(String code, T data) {
        this(code,SUCCESS_MESG,data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", mesg='" + mesg + '\'' +
                ", data=" + data +
                '}';
    }
}