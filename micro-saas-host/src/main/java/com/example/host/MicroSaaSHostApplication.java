package com.example.host;

import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.example.host"})
public class MicroSaaSHostApplication {

    private static final Logger logger = LoggerFactory.getLogger(MicroSaaSHostApplication.class);
    private final PluginManager pluginManager;

    public MicroSaaSHostApplication(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @PostConstruct
    public void initPlugins() {
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        List<PluginWrapper> plugins = pluginManager.getStartedPlugins();
        logger.info("Plugins carregados:");
        for (PluginWrapper plugin : plugins) {
            logger.info("> {} - {}", plugin.getPluginId(), plugin.getDescriptor().getPluginDescription());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroSaaSHostApplication.class, args);
    }
}
