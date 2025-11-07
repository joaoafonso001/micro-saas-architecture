package com.example.urlshortenerplugin;

import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;

@Extension
public class UrlShortenerExtension implements ExtensionPoint {

    public String shorten(String url) {
        return "https://short.ly/" + url.hashCode();
    }
}
