package com.example.host.config;

import java.nio.file.Path;
import java.util.List;

import org.pf4j.PluginManager;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PluginConfig {

    @Bean
public PluginManager pluginManager() {
    Path pluginsPath = Path.of("..", "plugins").toAbsolutePath().normalize();
    return new SpringPluginManager(List.of(pluginsPath));
}

}
