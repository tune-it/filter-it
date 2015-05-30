package com.tuneit.filterit.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Created by tegoo on 5/11/15.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/docs/**").addResourceLocations("/swagger-ui/");
    }

}
