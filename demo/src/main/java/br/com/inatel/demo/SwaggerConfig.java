package br.com.inatel.demo;

import org.springframework.context.annotation.Configuration;
 import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 import org.springdoc.core.SpringDocUtils;
 @Configuration
 @EnableWebMvc
 public class SwaggerConfig implements WebMvcConfigurer {
 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
 registry.addResourceHandler("/swagger-ui/**")
 .addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/1.6.4/");
 }
static {
 SpringDocUtils.getConfig().addAnnotationsToIgnore(
 org.springframework.web.bind.annotation.RequestMapping.class);
 }
 }