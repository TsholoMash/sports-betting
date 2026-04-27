package com.sportsbetting.config;

import com.sportsbetting.model.Bet;
import com.sportsbetting.model.BetStatus;
import com.sportsbetting.repository.BetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(BetRepository repo) {
        return args -> {
            repo.save(new Bet(null, "user1", "event1", "market1", "winner1", 100.0, BetStatus.PENDING));
            repo.save(new Bet(null, "user2", "event1", "market1", "winner2", 150.0, BetStatus.PENDING));
        };
    }
}
