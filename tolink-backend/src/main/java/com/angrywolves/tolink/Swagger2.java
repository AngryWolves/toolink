package com.angrywolves.tolink;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.angrywolves.tolink.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);

    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact(" AngryWolves ", "https://github.com/AngryWolves", "");
        ApiInfo apiInfo = new ApiInfo("AngryWolves APIs",//大标题
                "" +
                        "【使用说明】：" +
                        "普通调用使用 try catch，" +
                        "ajax调用使用error回调函数。</br>" +
                        "【业务异常返回值(JSON)】：" +
                        " status 业务异常状态码；" +
                        " error 标准异常信息；" +
                        " message 自定义异常信息；" +
                        " exception 异常类型；" +
                        " timestamp 时间戳。" +
                        "",//小标题
                "1.0",//版本
                "https://github.com/AngryWolves",
                contact,//作者
                "AngryWolves",//链接显示文字
                "https://github.com/AngryWolves"//网站链接
        );
        return apiInfo;
    }
}
