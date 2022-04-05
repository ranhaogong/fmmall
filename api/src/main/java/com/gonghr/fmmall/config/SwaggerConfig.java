package com.gonghr.fmmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*swagger会帮助我们⽣成接⼝⽂档
     * 1：配置⽣成的⽂档信息
     * 2: 配置⽣成规则*/
    /*Docket封装接⼝⽂档信息*/
    @Bean
    public Docket getDocket() {

        //创建封⾯信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《锋迷商城》后端接⼝说明")
                .description("此⽂档详细说明了锋迷商城项⽬后端接⼝规范")
                .version("v 2.0.1")
                .contact(new Contact("gonghr", "https://www.cnblogs.com/gonghr", "ranhaogong@qq.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo) //指定⽣成的⽂档中的封⾯信息：⽂档标题、版本、作者
                .select().apis(RequestHandlerSelectors.basePackage("com.gonghr.fmmall.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
