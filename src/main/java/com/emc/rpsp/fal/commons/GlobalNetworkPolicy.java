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
@XmlType(name = "GlobalNetworkPolicy")
public class GlobalNetworkPolicy implements Validateable {

    @XmlElement(required = true)
    private LinkedList<String> dnsServers;
    @XmlElement(required = true)
    private LinkedList<String> dnsSuffixes;

}
