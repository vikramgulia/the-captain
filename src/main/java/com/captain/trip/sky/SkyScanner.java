package com.captain.trip.sky;

import com.captain.model.dao.Currency;
import com.captain.model.sky.QuoteResponse;
import com.captain.model.trip.sky.LocalesWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

@Service
public class SkyScanner {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

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
     * return quotes from sky scanner
     *
     * @param country
     * @param currency
     * @param locale
     * @param originPlace
     * @param destinationPlace
     * @param outboundPartialDate
     * @param inboundPartialDate
     * @return
     * @throws IOException
     */
    public QuoteResponse browseQuotes(
            String country,
            String currency,
            String locale,
            String originPlace,
            String destinationPlace,
            Date outboundPartialDate,
            Date inboundPartialDate
    ) throws IOException {
        /*/{country}
        /{currency}
        /{locale}/
        {originPlace}/
        {destinationPlace}/
        {outboundPartialDate}/
        {inboundPartialDate}?
        apiKey={apiKey}"
        */
        /*return restTemplate.getForObject(String
                        .format(
                                browsequotes + "/%s/%s/%s/%s/%s/%s/%s?apiKey=%s",
                                country,
                                currency,
                                locale,
                                originPlace,
                                destinationPlace,
                                outboundPartialDate,
                                inboundPartialDate,
                                skyKey
                        ),
                QuoteResponse.class);*/

        return OBJECT_MAPPER.
                readValue(Files
                                .readAllLines(new File(ClassLoader.getSystemResource("quoteResponse.json").getPath()).toPath())
                                .parallelStream()
                                .reduce((s, s2) -> s + s2)
                                .get(),
                        QuoteResponse.class);
    }

    //@Cacheable("skyLocales")
    public LocalesWrapper locales() {
        return restTemplate.getForObject(references + "locales?apiKey=" + skyKey, LocalesWrapper.class);
    }

    /**
     * List all currencies
     *
     * @return
     * @throws IOException
     */
    public static List<Currency> currencies() throws IOException {
        return OBJECT_MAPPER.readValue(Files
                .readAllLines(new File(ClassLoader.getSystemResource("currency.json").getPath()).toPath())
                .parallelStream()
                .reduce((s, s2) -> s + s2)
                .get(), List.class);
    }
}