package com.leyou.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ShopCorsConfiguration {

    @Bean
    public CorsFilter corsFilter(){

        CorsConfiguration configuration = new CorsConfiguration();
        // 允许的域
        configuration.addAllowedOrigin("http://manage.leyou.com");
        // 是否允许携带cookie
        configuration.setAllowCredentials(true);
        // 允许的方法
        configuration.addAllowedMethod("*");
        // 允许的请求头
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);


        return new CorsFilter(configurationSource);
    }

}
