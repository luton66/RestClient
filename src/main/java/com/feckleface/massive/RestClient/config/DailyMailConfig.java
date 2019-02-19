package com.feckleface.massive.RestClient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DailyMailConfig {

    @Bean
    public RestOperations createRestOperations(final ClientHttpRequestFactory clientHttpRequestFactory) {
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    public ClientHttpRequestFactory createClientHttpRequestFactory(@Value("${read.timeout}") final int connectTimeout,
                                                                   @Value("${connect.timeout}") final int readTimeout) {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();



        httpComponentsClientHttpRequestFactory.setConnectTimeout(connectTimeout);
        httpComponentsClientHttpRequestFactory.setReadTimeout(readTimeout);

        return httpComponentsClientHttpRequestFactory;
    }
}
