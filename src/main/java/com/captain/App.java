package com.captain;

import com.captain.repo.CurrencyRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.captain")
public class App {

    @Autowired
    CurrencyRepository currencyRepository;

    static ObjectMapper mapper = new ObjectMapper();

    Map<String, String> currencyMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class);
    }

    /*@Bean
    public CommandLineRunner run() {
        return args -> {
            Files.readAllLines(new File("/Users/vikram.gulia/Documents/projects/github/the-captain/src/main/resources/currency.txt").toPath())
                    .stream()
                    .forEach(line -> {
                        String[] lines = line.split(",");
                        if (lines.length > 0) {
                            String code = currencyMap.get(lines[1]);
                            if (code != null)
                                currencyMap.put(lines[1], code + " " + lines[0]);
                            else
                                currencyMap.put(lines[1], lines[0]);
                            System.out.println(String.format("('%s', '%s')", lines[1], lines[0]));
                        }
                    });

            String json = Files.readAllLines(new File("/Users/vikram.gulia/Documents/projects/github/the-captain/src/main/resources/currency.json").toPath())
                    .stream()
                    .reduce((s, s2) -> s + s2).get();

            JsonNode node = mapper.readTree(json);
            JsonNode currencies = node.get("Currencies");
            if (currencies.isArray()) {
                Iterator<JsonNode> it = currencies.iterator();
                while (it.hasNext()) {
                    JsonNode value = it.next();
                    String code = value.get("Code").asText();
                    String symbol = value.get("Symbol").asText();
                    currencyRepository.save(com.captain.model.dao.Currency.builder()
                            .code(code)
                            .symbol(value.get("Symbol").asText())
                            .country(currencyMap.get(code))
                            .thousandsSeparator(value.get("ThousandsSeparator").asText())
                            .decimalSeparator(value.get("DecimalSeparator").asText())
                            .symbolOnLeft(value.get("SymbolOnLeft").asText())
                            .spaceBetweenAmountAndSymbol(value.get("SpaceBetweenAmountAndSymbol").asText())
                            .roundingCoefficient(value.get("RoundingCoefficient").asText())
                            .decimalDigits(value.get("DecimalDigits").asText())
                            .build()
                    );
                }

            }
        };
    }*/

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}