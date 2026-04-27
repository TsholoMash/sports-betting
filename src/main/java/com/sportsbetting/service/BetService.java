package com.sportsbetting.service;

import com.sportsbetting.model.Bet;
import com.sportsbetting.model.BetStatus;
import com.sportsbetting.model.EventOutcome;
import com.sportsbetting.mq.RocketMqMockProducer;
import com.sportsbetting.repository.BetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BetService {

    private final BetRepository betRepository;
    private final RocketMqMockProducer mqProducer;

    public void processEventOutcome(EventOutcome eventOutcome) {

        List<Bet> bets = betRepository.findByEventId(eventOutcome.getEventId());

        for (Bet bet : bets) {

            if (bet.getEventWinnerId().equals(eventOutcome.getEventWinnerId())) {
                bet.setStatus(BetStatus.WON);
            } else {
                bet.setStatus(BetStatus.LOST);
            }

            betRepository.save(bet);
            mqProducer.sendSettlement(bet);
        }
    }
}
