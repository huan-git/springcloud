package com.ahuan.test;

import com.ahuan.common.response.Result;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.exceptions.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ahun
 * @Description
 * @createDate 2019/06/10 14:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest   {
    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;

    // 1.定义一个变量保存session
    protected MockHttpSession session;

    @Before
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        //2.初始化session,基于session做登录的，需要验证session
        session = new MockHttpSession();
        //拦截器那边会判断用户是否登录，所以这里注入一个用户
        JSONObject user=new JSONObject();
        user.put("name","张三");
        user.put("id",00001);
        session.setAttribute("user",user);
        mockBehave();
    }

    public String test(String url, String json, HttpMethod method) {
        ResultActions resultActions = null;
        try {
            if (method == HttpMethod.POST) {
                MockHttpServletRequestBuilder content = post(url)
                        //传json参数
                        .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
                        .session(session);
                if (json != null) {
                    content.content(json);
                }
                resultActions = mockMvc.perform(content);
            }
            if (method == HttpMethod.GET) {
                resultActions = mockMvc.perform(get(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
                        .session(session));
            }
            MockHttpServletResponse response = resultActions.andReturn().getResponse();
            resultActions.andExpect(status().isOk()).andDo(print());
            resultActions.andExpect(jsonPath("$.code").value(Result.SUCCESS));
            //得到返回代码
            int status=response.getStatus();
            //断言，判断返回请求是否正确
            Assert.assertEquals(HttpStatus.OK.value(),status);
            String contentAsString = response.getContentAsString();
            return contentAsString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void mockBehave();

    public boolean isSuccess(String res){
        JSONObject jsonObject = JSONObject.parseObject(res);
        return "0".equals(jsonObject.get("code"));
    }
}
