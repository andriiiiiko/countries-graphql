package com.andriiiiiko.countries.service;

import com.andriiiiiko.countries.model.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryService {

    private final HttpGraphQlClient httpGraphQlClient;


    public CountryService() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com/")
                .build();
        httpGraphQlClient = HttpGraphQlClient.builder(webClient).build();
    }

    public Mono<List<Country>> getCountries() {
        String document = """
                query {
                    countries {
                        name
                        emoji
                        currency
                        code
                        capital
                    }
                }
                """;

        return httpGraphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);
    }
}
