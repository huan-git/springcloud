package com.ahuan.sso.service;

import com.ahuan.sso.exception.MyOAuth2Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: MyOAuth2WebResponseExceptionTranslator  
* @Description: 自定义登录或者鉴权失败时的返回信息
* @author huan  
* @date 2020年1月16日  
*
 */
@Component
public class MyOAuth2WebResponseExceptionTranslator implements
                                                    WebResponseExceptionTranslator<OAuth2Exception>{

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {

        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(new MyOAuth2Exception(oAuth2Exception.getMessage()));
    }
}