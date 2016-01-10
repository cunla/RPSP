package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@SuppressWarnings("serial")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement

@JsonTypeName("ScaleIoConnectionParams")
@XmlType(name = "ScaleIoConnectionParams")
public class ScaleIoConnectionParams extends BaseConnectionParams {
    // Each IP in the list relates to an MDM IP. For ScaleIo mgmtIp (defined in BaseConnectionParams should be null)
    private HashSet<IPInformation> ipInfos;

    public ScaleIoConnectionParams(HashSet<IPInformation> ipInfos) {
        super(null);
        this.ipInfos = ipInfos;
    }

}
