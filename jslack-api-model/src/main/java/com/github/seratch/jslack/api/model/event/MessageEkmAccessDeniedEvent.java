package com.github.seratch.jslack.api.model.event;

import com.github.seratch.jslack.api.model.Attachment;
import com.github.seratch.jslack.api.model.block.LayoutBlock;
import lombok.Data;

import java.util.List;

/**
 * https://api.slack.com/events/message/ekm_access_denied
 */
@Data
public class MessageEkmAccessDeniedEvent implements Event {

    public static final String TYPE_NAME = "message";
    public static final String SUBTYPE_NAME = "ekm_access_denied";

    private final String type = TYPE_NAME;
    private final String subtype = SUBTYPE_NAME;
    private String channel;
    private boolean hidden;

    private String user;

    private String text;
    private List<LayoutBlock> blocks;
    private List<Attachment> attachments;

    private String eventTs;
    private String ts;
    private String channelType; // app_home, channel, group, im, mpim
}
