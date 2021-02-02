package com.ahuan.sso.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/***
 * 
* @ClassName: MyOAuth2Exception  
* @Description: 自定义MyOAuth2Exception
* @author huan  
* @date 2020年1月16日  
*
 */
@JsonSerialize(using = MyOAuthExceptionJacksonSerializer.class)
public class MyOAuth2Exception extends OAuth2Exception {
    public MyOAuth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public MyOAuth2Exception(String msg) {
        super(msg);
    }
}