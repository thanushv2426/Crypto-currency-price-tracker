
// src/main/java/com/example/crypto_tracker/repository/CryptoRepository.java
package com.example.crypto_tracker.repository;

import com.example.crypto_tracker.model.cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this as a repository component
public interface cryptorepository extends JpaRepository<cryptocurrency, String> {
    // JpaRepository provides all standard CRUD methods for free
}

