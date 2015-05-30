package com.tuneit.filterit.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by tegoo on 5/11/15.
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext
                = new AnnotationConfigWebApplicationContext();

        rootContext.register(WebConfig.class);

        ServletRegistration.Dynamic registration =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

}
