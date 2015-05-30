package com.tuneit.filterit.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tegoo on 5/30/15.
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    @Bean
    public SwaggerSpringMvcPlugin customImplementation(){

        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(springSwaggerConfig);

        swaggerSpringMvcPlugin.apiInfo(apiInfo());
        swaggerSpringMvcPlugin.apiVersion("1.0");
        swaggerSpringMvcPlugin.build();

        return swaggerSpringMvcPlugin;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Tune-It Filter-It Services Documetation")
                .build();
    }

}
