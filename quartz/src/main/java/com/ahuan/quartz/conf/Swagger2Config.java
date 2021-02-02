package com.ahuan.quartz.conf;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhanghuan
 * @description: swagger2配置文件类 @访问路径： 如 http://localhost:8080/swagger-ui.html
 * @create 2018-07-12 21:29
 * @Modify By:
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("uums")
                .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).forCodeGeneration(true)
                .select().apis(RequestHandlerSelectors.basePackage("com.example.quartz.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("任务管理平台接口清单").description("用于前后端交互和与外系统交互").version("1.0").build();
    }

}
