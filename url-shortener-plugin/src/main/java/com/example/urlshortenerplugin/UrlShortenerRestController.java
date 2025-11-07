package com.example.urlshortenerplugin;

import java.util.HashMap;
import java.util.Map;

import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Extension
@RestController
public class UrlShortenerRestController implements ExtensionPoint {

    @GetMapping("/url/shorten")
    public Map<String, String> shortenUrl(@RequestParam(name = "originalUrl", required = false) String originalUrl) {
        Map<String, String> response = new HashMap<>();

        if (originalUrl == null || originalUrl.isBlank()) {
            response.put("error", "URL inválida ou ausente.");
            return response;
        }

        int hash = Math.abs(originalUrl.hashCode());
        String shortUrl = "https://short.ly/" + Integer.toHexString(hash);

        response.put("originalUrl", originalUrl);
        response.put("shortUrl", shortUrl);
        response.put("status", "success");

        return response;
    }
}
