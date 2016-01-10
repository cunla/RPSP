package com.emc.rpsp.fal.commons;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@Data
@XmlType(name = "IPPort")
public class IPPort {
    private String ip;
    private int port;
}
