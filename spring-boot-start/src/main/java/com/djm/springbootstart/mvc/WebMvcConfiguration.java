package com.djm.springbootstart.mvc;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * 配置Spring WebMvc。这里勿加{@code @EnableWebMvc}注解，否则Spring-Boot不再介入。
 *
 * @author yw
 *
 */
@Configuration
@ComponentScan
public class WebMvcConfiguration implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Autowired ApplicationContext applicationContext;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor());
    }

    @EventListener
    public void on(ContextRefreshedEvent event) {
        LOGGER.info("Spring启动完成。");

        StringBuilder sb;

        sb = new StringBuilder();
        String[] names = applicationContext.getBeanDefinitionNames();
        sb.append("Spring共加载了").append(names.length).append("个Bean对象：").append(Arrays.toString(names));
        LOGGER.info(sb.toString());

        RequestMappingHandlerAdapter requestMappingHandlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
        List<?> messageConverters = requestMappingHandlerAdapter.getMessageConverters();
        sb = new StringBuilder();
        sb.append("Spring共加载了").append(messageConverters.size()).append("个消息转换器对象：").append(messageConverters.toString());
        LOGGER.info(sb.toString());
    }

}
