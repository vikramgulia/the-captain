package com.captain.trip.sky;

import com.captain.model.trip.sky.LocalesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SkyScanner {

    private RestTemplate restTemplate;

    @Value("${sky.urls.browsequotes}")
    private String browsequotes;
    @Value("${sky.urls.browseroutes}")
    private String browseroutes;
    @Value("${sky.urls.browsedates}")
    private String browsedates;
    @Value("${sky.urls.browsegrid}")
    private String browsegrid;
    @Value("${sky.urls.references}")
    private String references;

    @Value("${sky.key}")
    private String skyKey;

    @Autowired
    public SkyScanner(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * TODO
     *
     * @param country
     */
    public void browseQuotes(String country

    ) {

    }

    //@Cacheable("skyLocales")
    public LocalesWrapper locales() {
        return restTemplate.getForObject(references + "locales?apiKey=" + skyKey, LocalesWrapper.class);
    }
}
