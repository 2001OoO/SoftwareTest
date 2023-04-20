package com.nk.config;

import com.nk.interceptor.AdminInterceptor;
import com.nk.interceptor.UserInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan("com.nk.controller")
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
//    开启对静态资源的访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    视图解析
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/",".jsp");
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将加一个拦截器，检查会话，所有/admin开头的请求都经过此拦截器
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**");
    }

}
