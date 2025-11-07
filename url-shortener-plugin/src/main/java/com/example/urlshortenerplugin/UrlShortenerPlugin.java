package com.example.urlshortenerplugin;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

public class UrlShortenerPlugin extends Plugin {

    public UrlShortenerPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.println("✅ UrlShortenerPlugin iniciado!");
    }

    @Override
    public void stop() {
        System.out.println("🛑 UrlShortenerPlugin parado!");
    }
}
