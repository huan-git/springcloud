package com.ahuan.sso.service;

import com.alibaba.fastjson.JSONObject;
import com.ahuan.sso.model.CodeMessage;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 
* @ClassName: RestAuthAccessDeniedHandler  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author huan  
* @date 2020年1月16日  
*
 */
@Service
public class RestAuthAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(JSONObject.toJSONString(CodeMessage.AccessDenied));
    }
}
