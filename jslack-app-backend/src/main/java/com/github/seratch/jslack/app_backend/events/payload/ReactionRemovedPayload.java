package com.github.seratch.jslack.app_backend.events.payload;

import com.github.seratch.jslack.api.model.event.ReactionRemovedEvent;
import lombok.Data;

import java.util.List;

@Data
public class ReactionRemovedPayload implements EventsApiPayload<ReactionRemovedEvent> {

    private String token;
    private String enterpriseId;
    private String teamId;
    private String apiAppId;
    private String type;
    private List<String> authedUsers;
    private List<String> authedTeams;
    private String eventId;
    private Integer eventTime;

    private ReactionRemovedEvent event;
}
