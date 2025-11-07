package com.example.host.plugin;

import org.pf4j.ExtensionPoint;

public interface MicroSaaSModule extends ExtensionPoint {
    String getName();
    String getDescription();
}
