package it.qsbl.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/lib/");
        registry.addResourceHandler("/temp/**").addResourceLocations("classpath:/temp/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        super.addResourceHandlers(registry);

    }

}