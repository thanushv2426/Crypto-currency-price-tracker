package com.example.crypto_tracker.service;

import com.example.crypto_tracker.dto.CoinGeckoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class CoinGeckoApiService {

    private final WebClient webClient;

    public CoinGeckoApiService() {
        // Build a WebClient instance with the base URL
        this.webClient = WebClient.builder()
                .baseUrl("https://api.coingecko.com/api/v3")
                .build();
    }

    // Fetches the top cryptocurrencies from the CoinGecko API
    public Mono<List<CoinGeckoDto>> getTopCryptos() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/coins/markets")
                        .queryParam("vs_currency", "usd") // Query for prices in USD
                        .queryParam("order", "market_cap_desc") // Order by market cap descending
                        .queryParam("per_page", 20) // Fetch top 20 cryptos
                        .queryParam("page", 1)
                        .build())
                .retrieve() // Execute the request
                .bodyToFlux(CoinGeckoDto.class) // Convert the response to a Flux of DTOs
                .collectList(); // Collect all DTOs into a single list
    }
}