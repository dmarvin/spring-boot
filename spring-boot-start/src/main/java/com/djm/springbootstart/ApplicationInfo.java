package com.djm.springbootstart;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInfo {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInfo.class);

    @Autowired private ConfigurableEnvironment env;

    @PostConstruct
    void init() {
        printEnvironmentProperties();
    }

    /**
     * 打印环境属性信息。
     */
    public void printEnvironmentProperties() {
        Set<String> keys = new TreeSet<>();

        for (Iterator<PropertySource<?>> it = env.getPropertySources().iterator(); it.hasNext();) {
            PropertySource<?> propertySource = it.next();
            String name = propertySource.getName();
            if ("systemProperties".equals(name) || "systemEnvironment".equals(name)) {
                continue;
            }

            if (!(propertySource instanceof MapPropertySource)) {
                LOGGER.warn("PropertySource不是MapPropertySource类型：{}", propertySource);
                continue;
            }

            Map<String, Object> map = ((MapPropertySource) propertySource).getSource();
            keys.addAll(map.keySet());
        }

        for (String key : keys) {
            String value = env.getProperty(key);
            LOGGER.info("{} = {}", key, value);
        }
    }

}
