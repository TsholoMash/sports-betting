package com.sportsbetting.service;

import com.sportsbetting.model.EventOutcome;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, EventOutcome> kafkaTemplate;

    public void send(EventOutcome eventOutcome) {
        kafkaTemplate.send("event-outcomes", eventOutcome);
    }
}
