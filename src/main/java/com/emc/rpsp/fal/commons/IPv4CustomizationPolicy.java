package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("IPv4CustomizationPolicy")
@XmlType(name = "IPv4CustomizationPolicy")
public class IPv4CustomizationPolicy extends IPCustomizationPolicy {

    private static final String IPV4_REGEX = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);
    @XmlElement(required = true)
    private String subnetMask;

    public IPv4CustomizationPolicy(String ip, LinkedList<String> gateways, String subnetMask) {
        super(ip, gateways);
        this.subnetMask = subnetMask;
    }

}
