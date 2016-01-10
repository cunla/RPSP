package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ConnectHomeMethod {
    CONNECT_HOME_ESRS("ConnectHomeESRS"),
    CONNECT_HOME_EMAIL("ConnectHomeEmail"),
    CONNECT_HOME_NOT_ALLOWED("ConnectHomeNotAllowed"),
    CONNECT_HOME_FTPS("ConnectHomeFTPS"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }
}
