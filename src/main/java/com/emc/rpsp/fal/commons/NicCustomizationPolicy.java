package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NicCustomizationPolicy")
public class NicCustomizationPolicy implements Validateable {

    @XmlElement(required = true)
    private int adapterId;
    private String dnsDomain;
    private LinkedList<String> dnsServers;
    private String primaryWINS;
    @XmlElement(required = true)
    private NetBiosMode netBios;
    private String secondaryWINS;
    private IPv4CustomizationPolicy ipV4Policy;
    private IPv6CustomizationPolicy ipV6Policy;

}
