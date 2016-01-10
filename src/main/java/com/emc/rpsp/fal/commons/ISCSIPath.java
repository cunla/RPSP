package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@XmlRootElement

@JsonTypeName("ISCSIPath")
@XmlType(name = "ISCSIPath")
public class ISCSIPath extends Path {

    private String remoteIqn;
    private IPInformation remoteIpInformation;
    private Integer remotePort;
    private String localIqn;
    private IPInformation localIpInformation;

    public ISCSIPath(RpaUID rpaUID, String remoteIqn, IPInformation remoteIpInformation, Integer remotePort, String localIqn, IPInformation localIpInformation) {
        super(rpaUID);
        this.remoteIqn = remoteIqn;
        this.remoteIpInformation = remoteIpInformation;
        this.remotePort = remotePort;
        this.localIqn = localIqn;
        this.localIpInformation = localIpInformation;
    }
}
