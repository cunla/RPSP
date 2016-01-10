package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
@Data()
@NoArgsConstructor
@AllArgsConstructor()
@XmlRootElement
@XmlSeeAlso({IPv4CustomizationPolicy.class, IPv6CustomizationPolicy.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = IPv4CustomizationPolicy.class, name = "IPv4CustomizationPolicy"),
    @Type(value = IPv6CustomizationPolicy.class, name = "IPv6CustomizationPolicy")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPCustomizationPolicy")
public abstract class IPCustomizationPolicy implements Validateable {

    @XmlElement(required = true)
    private String ip;
    @XmlElement(required = true)
    private LinkedList<String> gateways;

    public static void setDHCP(String DHCP) {
        IPCustomizationPolicy.DHCP = DHCP;
    }

    public static String getDHCP() {
        return DHCP;
    }

    private static String DHCP = "DHCP";

}
