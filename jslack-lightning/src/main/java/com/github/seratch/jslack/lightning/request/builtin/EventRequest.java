package com.github.seratch.jslack.lightning.request.builtin;

import com.github.seratch.jslack.common.json.GsonFactory;
import com.github.seratch.jslack.lightning.context.builtin.DefaultContext;
import com.github.seratch.jslack.lightning.request.Request;
import com.github.seratch.jslack.lightning.request.RequestHeaders;
import com.github.seratch.jslack.lightning.request.RequestType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.ToString;

@ToString(callSuper = true)
public class EventRequest extends Request<DefaultContext> {

    private final String requestBody;
    private final RequestHeaders headers;
    private final String eventType;
    private final String eventSubtype;

    public EventRequest(
            String requestBody,
            RequestHeaders headers) {
        this.requestBody = requestBody;
        this.headers = headers;
        JsonObject payload = GsonFactory.createSnakeCase().fromJson(requestBody, JsonElement.class).getAsJsonObject();
        JsonObject event = payload.get("event").getAsJsonObject();
        this.eventType = event.get("type").getAsString();
        if (event.get("subtype") != null) {
            this.eventSubtype = event.get("subtype").getAsString();
        } else {
            this.eventSubtype = null;
        }
        this.getContext().setTeamId(payload.get("team_id").getAsString());
        JsonElement enterpriseId = payload.get("enterprise_id");
        if (enterpriseId != null) {
            this.getContext().setTeamId(enterpriseId.getAsString());
        }
    }

    private DefaultContext context = new DefaultContext();

    @Override
    public DefaultContext getContext() {
        return context;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.Event;
    }

    @Override
    public String getRequestBodyAsString() {
        return requestBody;
    }

    @Override
    public RequestHeaders getHeaders() {
        return this.headers;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventTypeAndSubtype() {
        return eventType + ":" + eventSubtype;
    }
}
