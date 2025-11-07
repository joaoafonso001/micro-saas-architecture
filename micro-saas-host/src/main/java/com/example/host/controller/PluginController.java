package com.example.host.controller;

import org.pf4j.PluginManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PluginController {

    private final PluginManager pluginManager;

    public PluginController(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @GetMapping("/plugins")
    public List<String> listarPlugins() {
        return pluginManager.getPlugins().stream()
                .map(p -> {
                    var desc = p.getDescriptor();
                    return desc.getPluginId() + " - " + desc.getVersion();
                })
                .collect(Collectors.toList());
    }
}
