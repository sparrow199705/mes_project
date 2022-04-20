package com.drs.mes.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  //项目中的所有接口都支持跨域--当Credentials为true时，Origin不能为星号，需为具体的ip地址【如果接口不带cookie,ip无需设成具体ip】
//                .allowedOrigins("*")    // 允许跨域的域名，可以用*表示允许任何域名使用
                  .allowedOriginPatterns("*") // 设置允许跨域请求的域名
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600)   // maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
                .allowedHeaders("*")
                .allowCredentials(true); // 允许Cookie跨域，在做登录校验的时候有用
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/","/*/user/login");
    }

}
