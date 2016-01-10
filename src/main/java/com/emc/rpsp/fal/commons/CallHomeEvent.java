package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallHomeEvent")
public class CallHomeEvent implements Validateable {

    @XmlElement(required = true)
    private CallHomeEventUID id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String description;
    private boolean systemDefined;
    private RecoverPointTimeStamp disabledUntil;
    @XmlElement(required = true)
    private String script;

    public CallHomeEvent() {
    }

    public CallHomeEvent(CallHomeEventUID id, String name, String description, boolean systemDefined,
                         RecoverPointTimeStamp disabledUntil, String script) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.systemDefined = systemDefined;
        this.disabledUntil = disabledUntil;
        this.script = script;
    }

    public CallHomeEventUID getId() {
        return id;
    }

    public void setId(CallHomeEventUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getSystemDefined() {
        return systemDefined;
    }

    public void setSystemDefined(boolean systemDefined) {
        this.systemDefined = systemDefined;
    }

    public RecoverPointTimeStamp getDisabledUntil() {
        return disabledUntil;
    }

    public void setDisabledUntil(RecoverPointTimeStamp disabledUntil) {
        this.disabledUntil = disabledUntil;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

}
