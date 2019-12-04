package cn.fairyzww.blog.config;


import cn.fairyzww.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 16:06
 * @Description: 自定义WebConfig
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**")
                /**
                 - *：只匹配字符
                 - /**： 匹配所有路径
                 - /admin/**：匹配 /admin/ 下的所有路径
                 - /secure/*：只匹配 /secure/user，不匹配 /secure/user/info
                 */
                .excludePathPatterns("/admin", "/admin/login");
    }
}
