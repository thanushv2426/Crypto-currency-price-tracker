package com.example.crypto_tracker.scheduler;

import com.example.crypto_tracker.dto.CoinGeckoDto;
import com.example.crypto_tracker.model.cryptocurrency;
import com.example.crypto_tracker.repository.cryptorepository;
import com.example.crypto_tracker.service.CoinGeckoApiService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CryptoScheduler {

    private final CoinGeckoApiService coinGeckoApiService;
    private final cryptorepository cryptoRepository;

    public CryptoScheduler(CoinGeckoApiService coinGeckoApiService, cryptorepository cryptoRepository) {
        this.coinGeckoApiService = coinGeckoApiService;
        this.cryptoRepository = cryptoRepository;
    }

    // This method will run every 5 minutes
    @Scheduled(fixedRate = 300000) // 300000 ms = 5 minutes
    public void fetchAndSaveCryptos() {
        System.out.println("Fetching crypto prices...");
        coinGeckoApiService.getTopCryptos()
                .subscribe(coinGeckoDtos -> {
                    List<cryptocurrency> cryptos = coinGeckoDtos.stream()
                            .map(this::convertToEntity)
                            .collect(Collectors.toList());
                    cryptoRepository.saveAll(cryptos);
                    System.out.println("Saved " + cryptos.size() + " cryptocurrencies.");
                }, throwable -> System.err.println("Error fetching prices: " + throwable.getMessage()));
    }

    // Helper method to convert the DTO to an Entity
    private cryptocurrency convertToEntity(CoinGeckoDto dto) {
        cryptocurrency crypto = new cryptocurrency();
        crypto.setId(dto.getId());
        crypto.setName(dto.getName());
        crypto.setSymbol(dto.getSymbol());
        crypto.setCurrentPrice(dto.getCurrentPrice());
        crypto.setMarketCap(dto.getMarketCap());
        crypto.setLastUpdated(dto.getLastUpdated());
        return crypto;
    }
}