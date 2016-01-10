package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

@SuppressWarnings("serial")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("IPv6CustomizationPolicy")
@XmlType(name = "IPv6CustomizationPolicy")
public class IPv6CustomizationPolicy extends IPCustomizationPolicy {

    @XmlElement(required = true)
    private int ipV6SubnetPrefixLength;

    public IPv6CustomizationPolicy(String ipV6, LinkedList<String> gateways, int ipV6SubnetPrefixLength) {
        super(ipV6, gateways);
        this.ipV6SubnetPrefixLength = ipV6SubnetPrefixLength;
    }

}
