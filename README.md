# Cryptocurrency Price Tracker 🚀

A Spring Boot backend application that tracks real-time cryptocurrency prices
using the CoinGecko API and exposes RESTful APIs for data access.

---

## 🔹 Features
- Fetches real-time cryptocurrency prices from CoinGecko
- Stores data in H2 in-memory database
- Scheduled task updates prices every 5 minutes
- Exposes REST APIs to query crypto data
- Clean layered architecture (Controller, Service, Repository)

---

## 🔹 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- WebClient (Reactive)
- H2 Database
- Maven
- Git & GitHub

---

## 🔹 API Endpoints

| Method | Endpoint | Description |
|------|--------|------------|
| GET | `/api/cryptos` | Get all cryptocurrencies |
| GET | `/api/cryptos/top/3` | Get top 3 cryptos by market cap |
| GET | `/api/cryptos/{symbol}` | Get crypto by symbol (btc, eth) |

---
## H2 database console
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:cryptodb
- Username: thanush
- password: 123456

## 🔹 Running the Application
./mvnw spring-boot:run

## AUTHOR
- V.THANUSH
- email : thanush.v2426@gmail.com





