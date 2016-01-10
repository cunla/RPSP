package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ConnectInMethod {
    CONNECT_IN_ESRS("ConnectInESRS"),
    CONNECT_IN_WEBEX("ConnectInWebex"),
    CONNECT_IN_NOT_ALLOWED("ConnectInNotAllowed"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
