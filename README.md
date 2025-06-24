# 💱 Exchange Rate API - Spring Boot Application

This is a Spring Boot 3 backend service that:
- Connects to [ExchangeRate API](https://www.exchangerate-api.com) to fetch currency exchange rates.
- Stores them in a local MySQL database.
- Exposes a REST endpoint to fetch the latest exchange rate for a given currency pair.
- Built to be consumed by a **React Native** frontend.

---

## 🚀 Features

- ✅ REST API to get exchange rate: `/exchange-rate?from=USD&to=INR`
- ✅ Scheduled job to fetch latest rates from ExchangeRate API
- ✅ Stores rates with timestamp in MySQL
- ✅ Unit tests using `@WebMvcTest` and `@MockitoBean`
- ✅ Docker Compose setup for local MySQL container
- ✅ Compatible with mobile frontend (no web pages rendered)

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Web / WebFlux (for reactive HTTP)**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**
- **Docker Compose (for local MySQL setup)**

---

## 📦 API Endpoint

**GET** `/exchange-rate?from=USD&to=INR`

Returns the latest exchange rate as plain decimal value.

```http
GET http://localhost:8080/exchange-rate?from=USD&to=INR
Response: 86.63
