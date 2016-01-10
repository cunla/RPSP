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

@JsonTypeName("FiberChannelPath")
@XmlType(name = "FiberChannelPath")
public class FiberChannelPath extends Path {

    private String remotePortWWN;
    private String localPortWWN;
    private String localNodeWWN;

    public FiberChannelPath(RpaUID rpaUID, String remotePortWWN, String localPortWWN, String localNodeWWN) {
        super(rpaUID);
        this.remotePortWWN = remotePortWWN;
        this.localPortWWN = localPortWWN;
        this.localNodeWWN = localNodeWWN;
    }
}
