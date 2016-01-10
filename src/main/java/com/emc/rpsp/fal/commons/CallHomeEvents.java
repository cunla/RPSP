package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallHomeEvents")
public class CallHomeEvents implements Validateable {

    @XmlElement(required = true)
    private HashSet<CallHomeEvent> callHomeEvents;

    public CallHomeEvents() {
    }

    public CallHomeEvents(HashSet<CallHomeEvent> callHomeEvents) {
        this.callHomeEvents = callHomeEvents;
    }

    public HashSet<CallHomeEvent> getCallHomeEvents() {
        return callHomeEvents;
    }

    public void setCallHomeEvents(HashSet<CallHomeEvent> callHomeEvents) {
        this.callHomeEvents = callHomeEvents;
    }

}
