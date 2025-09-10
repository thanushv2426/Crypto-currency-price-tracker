package com.example.crypto_tracker.controller;

import com.example.crypto_tracker.model.cryptocurrency;
import com.example.crypto_tracker.repository.cryptorepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/cryptos")
public class CryptoController {

    private final cryptorepository cryptoRepository;

    public CryptoController(cryptorepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @GetMapping
    public List<cryptocurrency> getAllCryptos() {
        return cryptoRepository.findAll();
    }
}