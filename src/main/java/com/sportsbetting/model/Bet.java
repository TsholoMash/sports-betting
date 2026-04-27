package com.sportsbetting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bet {
    @Id
    @GeneratedValue
    private Long betId;

    private String userId;
    private String eventId;
    private String eventMarketId;
    private String eventWinnerId;
    private Double betAmount;

    @Enumerated(EnumType.STRING)
    private BetStatus status;
}
