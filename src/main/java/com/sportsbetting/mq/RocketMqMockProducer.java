package com.sportsbetting.mq;

import com.sportsbetting.model.Bet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RocketMqMockProducer {
    public void sendSettlement(Bet bet) {
        log.info("Mock RocketMQ - Sending settlement for bet: {}", bet);
    }
}
