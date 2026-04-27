package com.sportsbetting.dto;

import com.sportsbetting.model.EventOutcome;
import lombok.Data;

@Data
public class EventOutcomeRequest {
    private String eventId;
    private String eventName;
    private String eventWinnerId;

    public EventOutcome toEventOutcome() {
        EventOutcome outcome = new EventOutcome();
        outcome.setEventId(eventId);
        outcome.setEventName(eventName);
        outcome.setEventWinnerId(eventWinnerId);
        return outcome;
    }
}
