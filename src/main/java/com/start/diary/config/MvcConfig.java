package com.start.diary.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
//security.ftl 8vid 5.55
    //its value from properties see
    @Value("${upload.path}")
    private String uploadPath;

    //reCaptcha
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    //Login from Spring Framework
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
    }
    //For Add Css or Security will not let us use it
    //Also see WebSecurityConfig
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/css/**")
                // classpath: means----- search will be inside the our project from the root
                //Spring will find folder  "/template/static"
                //without this css-style won't work
                .addResourceLocations("classpath:/templates/css/");

        //File
        //All requests on url /img/** will go to the "file:///"+uploadPath+"/"
        //file:/// - it means on computer
        //classpath:--- it means root of project
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:///"+uploadPath+"/");

    }
}