# Sports Betting Settlement Service

## Overview
This project simulates a sports betting backend service that processes event outcomes and settles bets using an event-driven architecture.

The system publishes event outcomes to Kafka, processes them via a consumer, matches them against stored bets, and triggers settlement messages (mocked RocketMQ).

---

## Architecture & Flow

1. Client sends event outcome via REST API
2. Event is published to Kafka topic: `event-outcomes`
3. Kafka consumer listens and processes the event
4. Matching bets are retrieved from an in-memory database
5. Bets are evaluated (WON / LOST)
6. Settlement messages are sent (mocked RocketMQ via logs)

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Kafka
- H2 In-Memory Database
- Docker (Kafka & ZooKeeper)

---

## How to Run

### 1. Start Kafka (via Docker)
```bash
docker-compose up -d
```

### 2. Run the Application
```bash
./mvnw spring-boot:run
```

### 3. Access H2 Console (optional)
```bash
Open in browser:

http://localhost:8080/h2-console

Use:

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave empty)
```

### API Usage
```bash
POST /events/outcome
```

### Sample Request
```bash
curl -X POST http://localhost:8080/events/outcome \
-H "Content-Type: application/json" \
-d '{
  "eventId": "event1",
  "eventName": "Team A vs Team B",
  "eventWinnerId": "winner1"
}'
```