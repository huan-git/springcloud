package com.ahuan.common.util.http;

/**
 * ClassName:HttpClientResult <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年10月12日 下午3:24:02 <br/>
 *
 * @author liang
 * @see
 * @since JDK 1.8
 */
public class HttpClientResult {
    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }
}
  
