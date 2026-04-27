package com.sportsbetting.service;

import com.sportsbetting.model.EventOutcome;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final BetService betService;

    @KafkaListener(topics = "event-outcomes", groupId = "bet-group")
    public void consume(EventOutcome eventOutcome) {
        log.info("Received event outcome: {}", eventOutcome);
        betService.processEventOutcome(eventOutcome);
    }
}
