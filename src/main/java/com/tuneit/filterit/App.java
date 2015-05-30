package com.tuneit.filterit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tegoo on 5/8/15.
 */
@SpringBootApplication
public class App {

    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }

}
