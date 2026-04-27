package com.sportsbetting.controller;

import com.sportsbetting.dto.EventOutcomeRequest;
import com.sportsbetting.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/outcome")
    public ResponseEntity<String> publishEvent(@RequestBody EventOutcomeRequest request) {
        kafkaProducerService.send(request.toEventOutcome());
        return ResponseEntity.ok("Event published successfully");
    }
}
