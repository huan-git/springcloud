package com.ahuan.common.entity;

import java.io.Serializable;
import java.util.Date;

/***
* Created by Mybatis Generator on 2020/05/14
*/
public class SystemLog implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String clientId;

    /**
     * 
     */
    private String operatorUri;

    /**
     * 
     */
    private String operatorUserId;

    /**
     * 
     */
    private String operatorUserName;

    /**
     * 
     */
    private String operatorDescript;

    /**
     * 
     */
    private Date operatorTime;

    /**
     * 
     */
    private String operatorTimes;

    /**
     * 
     */
    private String className;

    /**
     * 
     */
    private String methodName;

    /**
     * 
     */
    private String httpMethod;

    /**
     * 
     */
    private String methodHeaders;

    /**
     * 
     */
    private String methodParams;

    /**
     * 
     */
    private String httpStatus;

    /**
     * 
     */
    private String response;

    /**
     * 
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOperatorUri() {
        return operatorUri;
    }

    public void setOperatorUri(String operatorUri) {
        this.operatorUri = operatorUri;
    }

    public String getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(String operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    public String getOperatorUserName() {
        return operatorUserName;
    }

    public void setOperatorUserName(String operatorUserName) {
        this.operatorUserName = operatorUserName;
    }

    public String getOperatorDescript() {
        return operatorDescript;
    }

    public void setOperatorDescript(String operatorDescript) {
        this.operatorDescript = operatorDescript;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getOperatorTimes() {
        return operatorTimes;
    }

    public void setOperatorTimes(String operatorTimes) {
        this.operatorTimes = operatorTimes;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getMethodHeaders() {
        return methodHeaders;
    }

    public void setMethodHeaders(String methodHeaders) {
        this.methodHeaders = methodHeaders;
    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}